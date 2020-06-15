import { Component, OnInit } from "@angular/core";

import { BsModalRef } from 'ngx-bootstrap/modal';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { MultitableService } from 'src/app/service/multitable.service';
import { MultitableModel } from 'src/app/models/multitable.model';
import { AlertService, MessageSeverity } from 'src/app/shared/services/alert.service';
import { AppConstants } from 'src/app/shared/constants/app.constants';


@Component({
  selector: 'multitable-insert-modal',
  templateUrl: './multitable-insert-modal.component.html'
})

export class ModalMultiTableInsertComponent implements OnInit {
  registerMultiTableForm: FormGroup;

  title: string;

  closeBtnName: string;
  acceptBtnName: string;

  submitted: boolean;

  multitable = [];

  public onClose: Subject<boolean>;

  constructor(
    public bsModalRef: BsModalRef,
    private formBuilder: FormBuilder,
    private MultitableService: MultitableService,
    private AlertService: AlertService,
  ) { }

  ngOnInit() {
    this.onReturnData(0);
    this.createInsertForm();
    this.onClose = new Subject();
  }

  createInsertForm() {
    this.registerMultiTableForm = this.formBuilder.group({
      tableId: ['', [Validators.required]],
      description: ['', [Validators.required]]
    });
  }

  /**
   * Get Form Group
   */
  get f() { return this.registerMultiTableForm.controls; }

  onCancel() {
    this.onClose.next(false);
    this.bsModalRef.hide();
  }

  onReturnData(id: number) {
    switch (id) {
      case 0:
        this.getData();
        break;
    }
  }

  getData() {
    this.multitable = [];
    this.MultitableService.getTablesList().subscribe(
      (result: MultitableModel[]) => {
        this.multitable = result
      },
      error => {
      }
    )
  }

  register(){
    this.submitted = true;
    let reg = this.registerMultiTableForm.value;

    reg.tableId = parseInt(reg.tableId)

    if (!this.registerMultiTableForm.controls.tableId.valid ||
      !this.registerMultiTableForm.controls.description.valid ) {

      this.AlertService.showMessage(AppConstants.TitleModal.REGISTER_TITLE,
        AppConstants.MessageModal.REQUIRED_FIELDS_MESSAGE,
        MessageSeverity.warn);
      return false;
    }

    this.MultitableService.createMultitableItem(reg).subscribe(
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
