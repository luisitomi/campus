import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { environment } from 'src/environments/environment';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AppRoutingModule, routingComponents, modalComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/module/shared.module';
import { HeaderComponent } from './shared/components/header/header.component';
import { CommonModule } from '@angular/common';
import { ModalModule, BsModalService } from 'ngx-bootstrap/modal';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpService } from './shared/services/http.service';
import { SpinnerService } from './shared/services/spinner.service';
import { AlertService } from './shared/services/alert.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './component/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    routingComponents,
    modalComponents,
  ],
  entryComponents: [
    modalComponents
  ],
  imports: [
    CommonModule,
    BrowserModule,
    SharedModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    ModalModule.forRoot(),
    ToastrModule.forRoot(),
    AppRoutingModule,
    PopoverModule.forRoot(),
    FontAwesomeModule,
  ],
  exports: [
    HeaderComponent
  ],
  providers: [
    //{
      //provide: HTTP_INTERCEPTORS,
      //useClass: ErrorInterceptor,
      //multi: true
    //},
    BsModalService,
    AlertService,
    BsModalService,
    SpinnerService,
    HttpService,
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  bootstrap: [AppComponent]
})
export class AppModule { }
