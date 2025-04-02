import { Component, ContentChild, ElementRef } from '@angular/core';
import { Customer } from './customer';

@Component({
  selector: 'app-customer-list',
  standalone: false,
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent {
  customers: Customer[] = [
    { customerNo: 1, name: "Ganesh", address: "Nashik", city: "Nashik", country: "India" },
    { customerNo: 2, name: "Ram", address: "Mumbai", city: "Mumbai", country: "India" },
    { customerNo: 3, name: "Vithu", address: "Pune", city: "Pune", country: "India" }
  ]

  name = ""
  paraVar = ""
  //@ContentChild('para') paraRef!: ElementRef

  showName(customer: any) {
    this.name = customer.name;
    // console.log(this.paraRef.nativeElement.textContent)
    // this.paraVar = this.paraRef.nativeElement.textContent
  }
}