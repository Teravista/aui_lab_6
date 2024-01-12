import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatTypeViewComponent } from './meatType-view-component';

describe('MeatTypeViewComponent', () => {
  let component: MeatTypeViewComponent;
  let fixture: ComponentFixture<MeatTypeViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatTypeViewComponent]
    });
    fixture = TestBed.createComponent(MeatTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
