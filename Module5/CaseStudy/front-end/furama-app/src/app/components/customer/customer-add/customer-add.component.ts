import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
      customerType : new FormControl('', Validators.required),
      code : new FormControl('', [Validators.required, Validators.pattern("^(KH-)\\d{4}$")]),
      name : new FormControl('', Validators.required),
      birthday : new FormControl('', Validators.required),
      gender : new FormControl(),
      idCard : new FormControl('', [Validators.required, Validators.pattern("(^\\d{9}$)|(^\\d{12}$)")]),
      email : new FormControl('', [Validators.required, Validators.email]),
      address : new FormControl('', Validators.required),
      phoneNumber : new FormControl('', [Validators.required, Validators.pattern("(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)")])
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
