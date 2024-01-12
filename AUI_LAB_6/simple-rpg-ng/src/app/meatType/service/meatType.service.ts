import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { MeatTypes } from "../model/meatTypes";
import {MeatTypeForm} from "../../meatType/model/meatType-form";
import {MeatTypeDetails} from "../../meatType/model/meatType-details";

/**
 * MeatType management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class MeatTypeService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all MeatTypes.
   *
   * @return list of MeatTypes
   */
  getMeatTypes(): Observable<MeatTypes> {
    return this.http.get<MeatTypes>('/api/meatTypes');
  }
  daleteMeatTypes(uuid: string): Observable<any> {
    return this.http.delete('/api/meatTypes/' + uuid);
  }

  putMeatType(uuid: string, request: MeatTypeForm): Observable<any> {
    return this.http.put('/api/meatTypes/' + uuid, request);
  }

  putMeatTypeAlone( request: MeatTypeForm): Observable<any> {
    return this.http.put('/api/meatTypes', request);
  }

  getMeatType(uuid: string): Observable<MeatTypeDetails> {
    return this.http.get<MeatTypeDetails>('/api/meatTypes/' + uuid);
  }

}
