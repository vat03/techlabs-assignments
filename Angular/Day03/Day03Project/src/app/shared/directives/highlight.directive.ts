import { Directive, ElementRef, HostBinding, HostListener, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: false
})
export class HighlightDirective implements OnInit {

  constructor(private element: ElementRef, private renderer: Renderer2) { }
  ngOnInit(): void {
    //this.renderer.setStyle(this.element.nativeElement, "color", "green")
  }

  // @HostListener('mouseover') onmouseover() {
  //   this.renderer.setStyle(this.element.nativeElement, "color", "yellow")
  // }

  // @HostListener('mouseleave') onmouseleave() {
  //   this.renderer.setStyle(this.element.nativeElement, "color", "black")
  // }

  @HostBinding('style.color') colortext: string = 'none'
  @HostBinding('style.border') bordertext: string = 'none'

  @HostListener('mouseover') onmouseover() {
    this.colortext='green'
    this.bordertext='solid 5px blue'
  }

  @HostListener('mouseleave') onmouseleave() {
    this.colortext='black'
    this.bordertext='none'
  }
}
