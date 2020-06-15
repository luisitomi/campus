import { Component, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { EventsService } from 'src/app/service/events.service';
import { AlertService, MessageSeverity } from 'src/app/shared/services/alert.service';
import { Router, NavigationEnd } from '@angular/router';
import { EventListAllModel } from 'src/app/models/events.model';
import { AppConstants } from 'src/app/shared/constants/app.constants';

import { faPlus, faEdit, faEye, faTrash } from '@fortawesome/free-solid-svg-icons';
import { ModalEventsInsertComponent } from 'src/app/shared/components/modals/events/insert/events-insert-modal.component';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events = [];
  eventsCopy = [];
  eventscomi = [];

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
    private EventsService: EventsService,
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

  openInsertLocalModal() {
    const initialState = {
      title: 'Agregar vento'
    };
    this.bsModalRef = this.modalService.show(ModalEventsInsertComponent, { backdrop: 'static', keyboard: true, class: 'modal-md', initialState });
  }

  ngOnInit(): void {
    this.onReturnData(1);
  }

  onReturnData(id: number) {
    switch (id) {
      case 0:
        this.getData();
        break;
    }
  }

  getData() {
    this.events = [];
    this.EventsService.getEvents().subscribe(
      (result: EventListAllModel[]) => {
        this.events = result
      },
      error => {
      }
    )
  }

  j:number =0;
  search(){
    if (this.busqueda == "" || this.busqueda == null) {
      this.onReturnData(0);
    } else {
      const searchData = [];
      try{
        for(let i = 0;this.events.length > i;i++){
          for(this.j = 0;this.events.length > this.j;this.j++){
          this.eventscomi = this.eventscomi.concat([{
                                                      name:this.events[i].commissars[this.j].name,
                                                      typeId:this.events[i].commissars[this.j].typeId,
                                                      duration:this.events[i].duration,
                                                      participants:this.events[i].participants,
                                                      eventId:this.events[i].eventId
                                                    }])
          }
        }
        for (const l of this.eventscomi) {
          if (l.name.toLowerCase().indexOf(this.busqueda.toLowerCase()) > -1) {
            searchData.push(l)
          }
        }
        if (searchData.length > 0) {
          this.events = [];
          for(let k = 0;searchData.length > k;k++){
            this.events = this.events.concat([{
                            eventId:searchData[k].eventId,
                            duration:searchData[k].duration,
                            participants:searchData[k].participants,
                            commissars:[{
                              name:searchData[k].name,
                              typeId:searchData[k].typeId
                            }]
                          }]);
          }
        } else {
          this.onReturnData(1);
          this.busqueda = "";
          this.AlertService.showMessage(AppConstants.TitleModal.WARNING_TITLE,
            AppConstants.MessageModal.DATA_EMPTY,
            MessageSeverity.warn);
        }
      }catch{
        this.onReturnData(1);
        this.busqueda = "";
          this.AlertService.showMessage(AppConstants.TitleModal.WARNING_TITLE,
            AppConstants.MessageModal.DATA_EMPTY,
            MessageSeverity.warn);
      }
      
    }
  }

}
