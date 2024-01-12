import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatTypeAddComponent } from './meatType-add.component';

describe('MeatTypeAddComponent', () => {
  let component: MeatTypeAddComponent;
  let fixture: ComponentFixture<MeatTypeAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatTypeAddComponent]
    });
    fixture = TestBed.createComponent(MeatTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
