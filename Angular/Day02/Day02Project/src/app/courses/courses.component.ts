import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-courses',
  standalone: false,
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.css'
})
export class CoursesComponent {
  @Input() paidCourse:number = 0;
  @Input() freeCourse:number = 0;
  @Input() totalCourse:number = 0;
}
