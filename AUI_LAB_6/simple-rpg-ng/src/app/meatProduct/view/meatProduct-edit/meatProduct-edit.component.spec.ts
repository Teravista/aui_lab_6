import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatProductEditComponent } from './meatProduct-edit.component';

describe('MeatProductEditComponent', () => {
  let component: MeatProductEditComponent;
  let fixture: ComponentFixture<MeatProductEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatProductEditComponent]
    });
    fixture = TestBed.createComponent(MeatProductEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
