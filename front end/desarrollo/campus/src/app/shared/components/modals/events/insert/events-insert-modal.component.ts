import { Component, OnInit } from "@angular/core";

import { BsModalRef } from 'ngx-bootstrap/modal';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { EventsService } from 'src/app/service/events.service';
import { EventListAllModel, commissarModel } from 'src/app/models/events.model';
import { AlertService, MessageSeverity } from 'src/app/shared/services/alert.service';
import { AppConstants } from 'src/app/shared/constants/app.constants';


@Component({
  selector: 'events-insert-modal',
  templateUrl: './events-insert-modal.component.html'
})

export class ModalEventsInsertComponent implements OnInit {
  registerEventsForm: FormGroup;

  title: string;

  closeBtnName: string;
  acceptBtnName: string;

  submitted: boolean;

  Events = [];
  EventsComi = [];

  public onClose: Subject<boolean>;

  constructor(
    public bsModalRef: BsModalRef,
    private formBuilder: FormBuilder,
    private EventsService: EventsService,
    private AlertService: AlertService,
  ) { }

  ngOnInit() {
    this.onReturnData(0);
    this.createInsertForm();
    this.onClose = new Subject();
  }

  createInsertForm() {
    this.registerEventsForm = this.formBuilder.group({
      tableId: ['', [Validators.required]],
      description: ['', [Validators.required]],
      list: ['', [Validators.required]]
    });
  }

  /**
   * Get Form Group
   */
  get f() { return this.registerEventsForm.controls; }

  onCancel() {
    this.onClose.next(false);
    this.bsModalRef.hide();
  }

  onReturnData(id: number) {
    switch (id) {
      case 0:
        this.getData();
        this.getDataComi();
        break;
    }
  }

  getData() {
    this.Events = [];
    this.EventsService.getEvents().subscribe(
      (result: EventListAllModel[]) => {
        this.Events = result
      },
      error => {
      }
    )
  }

  getDataComi() {
    this.EventsComi = [];
    this.EventsService.getCommissar().subscribe(
      (result: commissarModel[]) => {
        this.EventsComi = result
      },
      error => {
      }
    )
  }

  register(){
    this.submitted = true;
    let reg = this.registerEventsForm.value;

    reg.tableId = parseInt(reg.tableId)

    if (!this.registerEventsForm.controls.tableId.valid ||
      !this.registerEventsForm.controls.description.valid ) {

      this.AlertService.showMessage(AppConstants.TitleModal.REGISTER_TITLE,
        AppConstants.MessageModal.REQUIRED_FIELDS_MESSAGE,
        MessageSeverity.warn);
      return false;
    }

    this.EventsService.createEventItem(reg).subscribe(
      result => {
        if (result) {
          this.AlertService.showMessage(AppConstants.TitleModal.REGISTER_TITLE,
            AppConstants.MessageModal.REGISTER_CREATED,
            MessageSeverity.success);
          this.onClose.next(true);
          this.bsModalRef.hide();
        } else {
          this.AlertService.showMessage(AppConstants.TitleModal.ERROR_TITLE,
            result,
            MessageSeverity.error);
        }
      },
      error => {
        this.AlertService.showMessage(AppConstants.TitleModal.ERROR_TITLE,
          AppConstants.MessageModal.SOMETHING_WRONG,
          MessageSeverity.error);
      });
  }

}
