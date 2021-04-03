import { Component, OnInit } from '@angular/core';
import { Customer } from '../../../models/customer/Customer';
import { CustomerService } from '../../../services/customer-service/customer.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
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
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(){
    this.customerService.findAll().subscribe(customers => {
      this.customers = customers;
    },
     error => console.log(error));
  }

  openModal(customerId : number) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id : customerId
  };

    const dialogRef = this.dialog.open(DeleteModalComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(
      data => {
        if(data){
          this.customerService.delete(data).subscribe(() => {
            this.getAllCustomers(); 
          })
        }
      }
    );  
  }
}
