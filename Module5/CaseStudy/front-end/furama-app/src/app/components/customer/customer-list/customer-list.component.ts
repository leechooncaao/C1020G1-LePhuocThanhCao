import { Component, OnInit } from '@angular/core';
import { Customer } from '../../../models/customer/Customer';
import { CustomerService } from './../../../services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers : Customer[];


  constructor(private customerService : CustomerService) { }

  ngOnInit(): void {
    this.customerService.findAll().subscribe(customers => {
      this.customers = customers;
    console.log(this.customers);
    },
     error => console.log(error));
  }

}
