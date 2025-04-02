import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appCustomcolorchange]',
  standalone: false
})
export class CustomcolorchangeDirective {

  constructor(private element1: ElementRef) {
    this.element1.nativeElement.style.backgroundColor = "red"
  }
}
