import { Component, ElementRef, viewChild, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'first-app';
  name = "Virat";
  hidden = true
  result = ""
  xyz = true
  displayData = false

  getName() {
    return this.name;
  }

  disabled = "disabled"

  link = "https://www.google.com"
  image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTDe1OGZ6YC2jFkVQW0A0i_MiMUgcyE8BoXvJ26LhPSJYC7SUBZT-Gtn3yYeQ_xccasG8WAC_MM9sXZaRDpYjnrCQgwNS9l7spp0k1t2O0"

  data = 1;
  increamentData() {
    if (this.data < 15) {
      this.data++;
      return;
    }
    alert("Data should be less than 15")

  }

  decreamentData() {
    if (this.data > 0) {
      this.data--;
      return;
    }
    alert("Data should be greater than 0")
  }

  @ViewChild('box')
  val!: ElementRef
  sendData(value: any) {
    this.result = value
  }

  players = [
    { id: 1, name: "Sachin", email: "sachin@gmail.com" },
    { id: 2, name: "Virat", email: "virat@gmail.com" },
    { id: 3, name: "Rahul", email: "rahul@gmail.com" }
  ]

  taskArray:String[] = [];

  @ViewChild('taskBox') task!: ElementRef;
  sendTask(value: String) {
    if (this.taskArray.includes(value)) {
      alert("Task already exists!");
      return;
    }
    this.taskArray.push(value)
  }

  completedTaskArray:String[] = [];

  pushToCompleted(index: number) {
    let completedTask = this.taskArray.splice(index, 1)[0]; 
    if (completedTask) {
      this.completedTaskArray.push(completedTask);
    }
  }
  
  deleteTask(index: number) {
    this.taskArray.splice(index, 1); 
  }
  
  deleteCompletedTask(index: number) {
    this.completedTaskArray.splice(index, 1);
  }
}