import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanofficerdashboardComponent } from './loanofficerdashboard.component';

describe('LoanofficerdashboardComponent', () => {
  let component: LoanofficerdashboardComponent;
  let fixture: ComponentFixture<LoanofficerdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoanofficerdashboardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoanofficerdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
