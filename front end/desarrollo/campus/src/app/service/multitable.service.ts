import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { HttpService } from '../shared/services/http.service';
import { Observable } from 'rxjs';
import { MultitableListAllModel, MultitableModel, MultitableItemsModel } from '../models/multitable.model';

@Injectable({
  providedIn: "root"
})

export class MultitableService {

  result: MultitableListAllModel[];

  constructor(private httpService: HttpService) { }

  private BASE_URL: string = environment.serviceApiEndPoint;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods':'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers: Origin':'Content-Type'
    })
  }
  
  /**
  * Get Tables
  */
  getTables(): Observable<MultitableListAllModel[]> {
    return this.httpService.get<MultitableListAllModel[]>(`${this.BASE_URL}/multitable/getListAllTables`);
  }

  getTablesList(): Observable<MultitableModel[]> {
    return this.httpService.get<MultitableModel[]>(`${this.BASE_URL}/multitable/getListTables`);
  }

  createMultitableItem(model: MultitableItemsModel) {
    return this.httpService.post(`${this.BASE_URL}/Multitable/postMultitableCreate`, model);
  }

  updateMultitableItem(model: MultitableItemsModel) {
    return this.httpService.put(`${this.BASE_URL}/Multitable/putMultitableUpdate`, model , this.httpOptions);
  }

  DeleteData(id:number){
    return this.httpService.delete<MultitableModel>(`${this.BASE_URL}/Multitable/deleteMultitable/` + id, this.httpOptions);
  }

}
