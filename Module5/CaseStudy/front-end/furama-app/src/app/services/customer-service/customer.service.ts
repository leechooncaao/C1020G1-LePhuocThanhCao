import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Customer } from '../../models/customer/Customer';

const httpOptions = {
  headers : new HttpHeaders({
    'Content-type' : 'application/json'
    
  })
};

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  baseUrl : string = 'http://localhost:8080/api/customer';

  constructor(private http : HttpClient) { }

  findAll():Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl);
  }

  create(customer : Customer): Observable<Customer>{
      return this.http.post<Customer>(this.baseUrl, customer);
  }

  update(id : number, customer : Customer) : Observable<Customer>{
    return this.http.put<Customer>(this.baseUrl + '/' + id, customer, httpOptions)
  }

  findById(id : number) : Observable<Customer>{
    return this.http.get<Customer>(this.baseUrl+ '/' + id, httpOptions);
  }

  delete(id : number) : Observable<Customer>{
    return this.http.delete<Customer>(this.baseUrl + '/' + id, httpOptions);
  }
}
