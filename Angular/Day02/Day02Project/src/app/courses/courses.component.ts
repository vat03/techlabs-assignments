import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-courses',
  standalone: false,
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  @Input() paidCourse: number = 0;
  @Input() freeCourse: number = 0;
  @Input() totalCourse: number = 0;
  @Input() selectedType: string = 'total';

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

  getFilteredCourses() {
    if (this.selectedType === 'total') {
      return this.courses;
    }
    return this.courses.filter(course => course.type.toLowerCase() === this.selectedType.toLowerCase());
  }

  filterCourses:any[]=[...this.courses];
  getType(data:any)
  {
    if(data == "Paid")
    {
      this.filterCourses = this.courses.filter((course)=> course.type == data)
    }

    else if(data == "Free")
    {
      this.filterCourses = this.courses.filter((course)=> course.type == data)
    }

    else{
      this.filterCourses= this.courses
    }
  }
}
