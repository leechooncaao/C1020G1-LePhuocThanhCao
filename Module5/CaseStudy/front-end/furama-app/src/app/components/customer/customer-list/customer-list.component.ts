import { Component, OnInit } from '@angular/core';
import { Customer } from '../../../models/customer/Customer';
import { CustomerService } from '../../../services/customer-service/customer.service';
import {MatDialog} from '@angular/material/dialog';
import { DeleteModalComponent } from '../../modals/delete-modal/delete-modal.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers : Customer[];
  customerId : number;


  constructor(private customerService : CustomerService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.customerService.findAll().subscribe(customers => {
      this.customers = customers;
    },
     error => console.log(error));
  }

  openModal() {
    const dialogRef = this.dialog.open(DeleteModalComponent, {
      width: '250px',
      data: {customerId: this.customerId}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
