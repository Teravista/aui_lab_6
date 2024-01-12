import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatProductViewComponent } from './meatProduct-view-component';

describe('MeatProductViewComponent', () => {
  let component: MeatProductViewComponent;
  let fixture: ComponentFixture<MeatProductViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatProductViewComponent]
    });
    fixture = TestBed.createComponent(MeatProductViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
