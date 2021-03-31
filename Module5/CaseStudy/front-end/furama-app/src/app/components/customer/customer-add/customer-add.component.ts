import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer/Customer';
import { CustomerService } from 'src/app/services/customer.service';


@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})
export class CustomerAddComponent implements OnInit {
  customer : Customer = new Customer;

  // id : number;
  // code : string;
  // name : string;
  // birthday : string;
  // gender : string;
  // idCard : string;
  // phoneNumber : string;
  // email : string;
  // address : string;
  // customerType : CustomerType;


  constructor(private customerService : CustomerService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.customerService.create(this.customer).subscribe();
  }

}
