import { Component } from '@angular/core';
import { Employee } from './Employee';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'day05-form';
  employee: Employee = new Employee();
  firstName: string = '';
  lastName: string = '';
  contactNumber: number = 0;
  dateOfBirth: string = '';
  age: number = 0;

  onSubmit(){
    this.employee.firstName = this.firstName;
    this.employee.lastName = this.lastName;
    this.employee.contactNumber = this.contactNumber;
    this.employee.dateOfBirth = this.dateOfBirth;
    this.employee.age = this.age;
    console.log(this.employee);
  }
}