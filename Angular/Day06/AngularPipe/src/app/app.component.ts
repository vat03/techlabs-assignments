import { Component } from '@angular/core';
import { Student } from './model/Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AngularPipe';

  totalmarks: number = 700
  students: Student[] = [
    { name: "Rahul", course: "BE", marks: 570, dob: new Date("12-10-1890"), gender: "Male" },
    { name: "Sayali", course: "BCOM", marks: 675,dob:new Date("02-01-1989"),gender: "Female" },
  ]
}
