import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { HttpService } from '../shared/services/http.service';
import { Observable } from 'rxjs';
import { EventListAllModel, commissarModel } from '../models/events.model';

@Injectable({
  providedIn: "root"
})

export class EventsService {

  result: EventListAllModel[];

  constructor(private httpService: HttpService) { }

  private BASE_URL: string = environment.serviceApiEndPoint;
  private BASE_URL_POSgresql: string = environment.serviceApiEndPointPostGresql;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  }
  
  /**
  * Get Events
  */
  getEvents(): Observable<EventListAllModel[]> {
    return this.httpService.get<EventListAllModel[]>(`${this.BASE_URL_POSgresql}/events/get`);
  }

  getCommissar(): Observable<commissarModel[]> {
    return this.httpService.get<commissarModel[]>(`${this.BASE_URL_POSgresql}/events/getCommisar`);
  }

  createEventItem(model: EventListAllModel) {
    return this.httpService.post(`${this.BASE_URL}/events/save`, model);
  }

  updateEventItem(model: EventListAllModel) {
    return this.httpService.put(`${this.BASE_URL}/events/update`, model , this.httpOptions);
  }

}
