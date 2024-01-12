import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatTypeEditComponent } from './meatType-edit.component';

describe('MeatTypeEditComponent', () => {
  let component: MeatTypeEditComponent;
  let fixture: ComponentFixture<MeatTypeEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatTypeEditComponent]
    });
    fixture = TestBed.createComponent(MeatTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
