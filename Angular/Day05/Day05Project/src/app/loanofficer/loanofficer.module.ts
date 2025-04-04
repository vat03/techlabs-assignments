import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoanofficerRoutingModule } from './loanofficer-routing.module';
import { LoanofficerdashboardComponent } from './loanofficerdashboard/loanofficerdashboard.component';


@NgModule({
  declarations: [
    LoanofficerdashboardComponent
  ],
  imports: [
    CommonModule,
    LoanofficerRoutingModule
  ]
})
export class LoanofficerModule { }
