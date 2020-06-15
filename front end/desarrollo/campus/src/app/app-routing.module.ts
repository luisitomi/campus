import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './shared/components/header/header.component';
import { ModalMultiTableInsertComponent } from './shared/components/modals/multitable/insert/multitable-insert-modal.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { MultitableComponent } from './component/multitable/multitable.component';
import { ModalMultiTableUpdateComponent } from './shared/components/modals/multitable/update/multitable-update-modal.component';
import { EventsComponent } from './component/events/events.component';
import { LoginComponent } from './component/login/login.component';
import { ModalEventsInsertComponent } from './shared/components/modals/events/insert/events-insert-modal.component';


const routes: Routes = [
  {path: '', component: DashboardComponent,},
      { path: '', redirectTo:'home', pathMatch: 'full' },

      { path: 'home', component: DashboardComponent },
      { path: 'multitable', component: MultitableComponent },
      { path: 'event', component: EventsComponent },
  { path: '' , redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
]

@NgModule({
  imports: [
    RouterModule.forRoot( routes ,{
        onSameUrlNavigation: 'reload',
        enableTracing: false
    }), FormsModule
  ],
  exports: [
    RouterModule
  ],
})
export class AppRoutingModule { }

export const routingComponents = [
  HeaderComponent,
  MultitableComponent,
  EventsComponent,
]

export const modalComponents  = [
  ModalMultiTableInsertComponent,
  ModalMultiTableUpdateComponent,
  ModalEventsInsertComponent
]
