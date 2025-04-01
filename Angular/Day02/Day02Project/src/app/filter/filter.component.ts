import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-filter',
  standalone: false,
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
  
  @Output() eventToParentFromChild = new EventEmitter<string>();
  type: string = 'total';

  sendType() {
    this.eventToParentFromChild.emit(this.type);
  }
}