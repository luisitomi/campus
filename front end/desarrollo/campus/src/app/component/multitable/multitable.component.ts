import { Component, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Router, NavigationEnd } from '@angular/router';
import { ModalMultiTableInsertComponent } from '../../shared/components/modals/multitable/insert/multitable-insert-modal.component';
import { MultitableService } from 'src/app/service/multitable.service';
import { MultitableListAllModel } from 'src/app/models/multitable.model';
import { AppConstants } from 'src/app/shared/constants/app.constants';
import { MessageSeverity, AlertService } from 'src/app/shared/services/alert.service';

import { faPlus, faEdit, faEye, faTrash } from '@fortawesome/free-solid-svg-icons';
import { ModalMultiTableUpdateComponent } from 'src/app/shared/components/modals/multitable/update/multitable-update-modal.component';

@Component({
  selector: 'app-multitable',
  templateUrl: './multitable.component.html',
  styleUrls: ['./multitable.component.css']
})
export class MultitableComponent implements OnInit {

  multitable = [];

  busqueda:string;

  faEye = faEye;
  faEdit = faEdit;
  faPlus = faPlus;
  faTrash = faTrash;

  itemsPerPage: number = 3;
  currentPage: number = 1;
  
  bsModalRef: BsModalRef;

  constructor(
    private modalService: BsModalService,
    private MultitableService: MultitableService,
    private AlertService: AlertService,
    private router: Router,
  ) {
    this.router.events.subscribe(evt => {
      if (evt instanceof NavigationEnd) {
        this.router.navigated = false;
        window.scrollTo(0, 0);
        this.onReturnData(0);
      }
    })
  }

  ngOnInit(): void {
    this.onReturnData(0);
  }

  openInsertLocalModal() {
    const initialState = {
      title: 'Agregar Elemento'
    };
    this.bsModalRef = this.modalService.show(ModalMultiTableInsertComponent, { backdrop: 'static', keyboard: true, class: 'modal-md', initialState });
  }

  openUpdateLocalModal(id:number) {
    const initialState = {
      title: 'Editar Elemento',
      idInt:id,
      multi:this.multitable
    };
    this.bsModalRef = this.modalService.show(ModalMultiTableUpdateComponent, { backdrop: 'static', keyboard: true, class: 'modal-md', initialState });
  }

  getData() {
    this.multitable = [];
    this.MultitableService.getTables().subscribe(
      (result: MultitableListAllModel[]) => {
        this.multitable = result
      },
      error => {
      }
    )
  }

  search(){
    if (this.busqueda == "" || this.busqueda == null) {
      this.onReturnData(0);
    } else {
      const searchData = [];
      for (const l of this.multitable) {
        if (l.second.toLowerCase().indexOf(this.busqueda.toLowerCase()) > -1) {
          searchData.push(l)
        }
      }
      if (searchData.length > 0) {
        this.multitable = [];
        this.multitable = searchData;
      } else {
        this.busqueda = "";
        this.AlertService.showMessage(AppConstants.TitleModal.WARNING_TITLE,
          AppConstants.MessageModal.DATA_EMPTY,
          MessageSeverity.warn);
      }
    }
  }

  onReturnData(id: number) {
    switch (id) {
      case 0:
        this.getData();
        break;
    }
  }

  deleteData(id:number){
    this.MultitableService.DeleteData(id).subscribe(
      result => {
        if (result) {
          this.AlertService.showMessage(AppConstants.TitleModal.UPDATE_TITLE,
            AppConstants.MessageModal.REGISTER_UPDATED,
            MessageSeverity.success);
          this.onReturnData(0);
        } else {
          this.AlertService.showMessage(AppConstants.TitleModal.ERROR_TITLE,
            AppConstants.MessageModal.SOMETHING_WRONG,
            MessageSeverity.error);
        }
      },
      error => {
        this.AlertService.showMessage(AppConstants.TitleModal.ERROR_TITLE,
          AppConstants.MessageModal.SOMETHING_WRONG,
          MessageSeverity.error);
      }
    )
  }

}
