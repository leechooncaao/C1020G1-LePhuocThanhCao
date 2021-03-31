import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomerAddComponent } from './components/customer/customer-add/customer-add.component';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './components/customer/customer-edit/customer-edit.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './components/layout/footer/footer.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    CustomerAddComponent,
    CustomerListComponent,
    CustomerEditComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
  BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
