import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  @Input() dataFromRoot: string = "";

  sendResult: string = "";

  @Output() eventToParentFromChild: EventEmitter<string> = new EventEmitter<string>();

  sendData() {
    this.eventToParentFromChild.emit(this.sendResult);
  }
}
