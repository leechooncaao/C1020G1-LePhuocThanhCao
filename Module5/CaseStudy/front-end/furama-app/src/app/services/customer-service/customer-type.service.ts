import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerType } from 'src/app/models/customer/CustomerType';

const httpOptions = {
  headers : new HttpHeaders({
    'Content-type' : 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  baseUrl : string = 'http://localhost:3000/customer_type';
  constructor(private http : HttpClient) { }

  findAll() : Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.baseUrl);
  };

 
}
