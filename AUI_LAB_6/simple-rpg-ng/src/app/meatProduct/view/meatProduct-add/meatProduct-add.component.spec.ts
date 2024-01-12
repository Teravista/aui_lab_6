import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatProductAddComponent } from './meatProduct-add.component';

describe('MeatProductAddComponent', () => {
  let component: MeatProductAddComponent;
  let fixture: ComponentFixture<MeatProductAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatProductAddComponent]
    });
    fixture = TestBed.createComponent(MeatProductAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
