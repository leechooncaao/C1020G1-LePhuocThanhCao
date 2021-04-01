import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CustomerType } from 'src/app/models/customer/CustomerType';
import { CustomerTypeService } from 'src/app/services/customer-service/customer-type.service';
import { CustomerService } from 'src/app/services/customer-service/customer.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  customerForm : FormGroup;
  customerTypes : CustomerType[];
  customerId : number;
  message : string;

  constructor(private customerService : CustomerService, 
              private customerTypeSevice : CustomerTypeService,
              private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      id : new FormControl(),
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

    const promiseCustomerTypes = this.customerTypeSevice.findAll().toPromise();

    promiseCustomerTypes.then(customerTypes => {
      this.customerTypes = customerTypes;    
    });

    this.customerId = this.route.snapshot.params['customerId'];
    let promiseCustomer = this.customerService.findById(this.customerId).toPromise();

    promiseCustomer.then(customer => {
      this.customerForm.setValue(customer);
    })
  }

  onSubmit(){
    this.customerService.update(this.customerId, this.customerForm.value).subscribe(()=>{
      this.message = "Successfully updated !";
    })
  }
}
