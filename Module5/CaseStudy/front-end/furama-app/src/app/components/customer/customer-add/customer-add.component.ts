import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Customer } from 'src/app/models/customer/Customer';
import { CustomerTypeService } from 'src/app/services/customer-service/customer-type.service';
import { CustomerService } from 'src/app/services/customer-service/customer.service';
import { CustomerType } from './../../../models/customer/CustomerType';


@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})
export class CustomerAddComponent implements OnInit {
  customerForm : FormGroup;
  customerTypes : CustomerType[];
  message : string;

  constructor(private customerService : CustomerService, 
              private customerTypeSevice : CustomerTypeService) { }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      customerType : new FormControl(),
      code : new FormControl(),
      name : new FormControl(),
      birthday : new FormControl(),
      gender : new FormControl(),
      idCard : new FormControl(),
      email : new FormControl(),
      address : new FormControl(),
      phoneNumber : new FormControl()
    });

    const promise = this.customerTypeSevice.findAll().toPromise();

    promise.then(customerTypes => {
      this.customerTypes = customerTypes;

      this.customerForm.get('gender').setValue('Male');
      this.customerForm.get('customerType').setValue(this.customerTypes[0]);
    })
  }

  onSubmit(){
    this.customerService.create(this.customerForm.value).subscribe(()=>{
      this.message = "Successfully created !";
    })
  }
}
