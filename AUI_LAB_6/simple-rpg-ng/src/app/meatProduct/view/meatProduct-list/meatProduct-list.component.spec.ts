import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatProductListComponent } from './meatProduct-list.component';

describe('MeatProductListComponent', () => {
  let component: MeatProductListComponent;
  let fixture: ComponentFixture<MeatProductListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatProductListComponent]
    });
    fixture = TestBed.createComponent(MeatProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
