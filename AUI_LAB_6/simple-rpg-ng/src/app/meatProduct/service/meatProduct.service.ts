import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { MeatProducts } from "../model/meatProducts";
import { MeatProductDetails } from "../model/meatProduct-details";
import { MeatProductForm } from "../model/meatProduct-form";

/**
 * Character management service. Calls REST endpoints.
 */
@Injectable()
export class MeatProductService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all MeatProducts.
   *
   * @return list of MeatProducts
   */
  getMeatProducts(): Observable<MeatProducts> {
    return this.http.get<MeatProducts>('/api/meatProducts');
  }

  /**
   * Fetches single MeatProducts.
   *
   * @param uuid MeatProduct's id
   * @return single MeatProducts
   */
  getMeatProduct(uuid: string): Observable<MeatProductDetails> {
    return this.http.get<MeatProductDetails>('/api/meatProducts/' + uuid);
  }

  /**
   * Removes single character.
   *
   * @param uuid character's id
   */
  deleteMeatProduct(uuid: string): Observable<any> {
    return this.http.delete('/api/meatProducts/' + uuid);
  }

  getMeatTypeMeatProducts(uuid: string): Observable<MeatProducts>  {
    return this.http.get<MeatProducts>('/api/meatTypes/' + uuid+'/meatProducts');
  }

  /**
   * Updates single character.
   *
   * @param uuid character's id
   * @param request request body
   */
  putMeatProduct(uuid: string, request: MeatProductForm): Observable<any> {
    return this.http.put('/api/meatProducts/' + uuid, request);
  }
  putMeatProductAllone( request: MeatProductForm): Observable<any> {
    return this.http.put('/api/meatProducts', request);
  }

}
