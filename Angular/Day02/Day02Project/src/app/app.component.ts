import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Day02Project';
  data:string = "Rahul"

  getData()
  {
    return this.data
  }

  display()
  {
    console.log(this.data)
  }

  courses = [
    {
      id: 101, name: "Python", author: "Yogesh", duration: 48, price: 0.00, type: 'Free',
      rating: 4.5, image: '/assets/python.jfif', description: "In this course you will learn basic of python"
    },
    {
      id: 102, name: "Java", author: "Bharat", duration: 45, price: 250.00, type: 'Paid',
      rating: 4.5, image: '/assets/java.png', description: "In this course you will learn basic of core java"
    },
    {
      id: 103, name: "Angular", author: "Rishi", duration: 50, price: 500.00, type: 'Paid',
      rating: 4.5, image: '/assets/angular.png', description: "In this course you will learn basic of angular"
    },
    {
      id: 104, name: "React", author: "Mahesh", duration: 30, price: 0.00, type: 'Free',
      rating: 4.5, image: '/assets/react.jfif', description: "In this course you will learn basic of react"
    },
    {
      id: 105, name: "DotNet", author: "Ram", duration: 40, price: 40.00, type: 'Paid',
      rating: 4.5, image: '/assets/dotnet.png', description: "In this course you will learn basic of dotnet C#"
    },
  ];

  paidCourses:number = 0;
  freeCourses:number = 0;
  totalCourse:number = 0;

  getPaidCourseCount()
  {
    this.paidCourses = this.courses.filter((course)=> course.type == "Paid").length
    return this.paidCourses;
  }

  getFreeCourseCount()
  {
    this.freeCourses = this.courses.filter((course)=> course.type == "Free").length
    return this.freeCourses;
  }

  getTotalCourseCount()
  {
    this.totalCourse = this.paidCourses+this.freeCourses;

    return this.totalCourse
  }

  sendData(data:any){
    console.log(data)

  }

}
