import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerAddComponent } from './components/customer/customer-add/customer-add.component';
import { CustomerEditComponent } from './components/customer/customer-edit/customer-edit.component';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  { path:'customer', component: CustomerListComponent },
  { path:'customer/add', component: CustomerAddComponent },
  { path:'customer/edit/:customerId', component: CustomerEditComponent },
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
