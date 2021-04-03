import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
