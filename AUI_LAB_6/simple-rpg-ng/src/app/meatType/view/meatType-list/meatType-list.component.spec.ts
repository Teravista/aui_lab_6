import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatTypeListComponent } from './meatType-list.component';

describe('MeatTypeListComponent', () => {
  let component: MeatTypeListComponent;
  let fixture: ComponentFixture<MeatTypeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeatTypeListComponent]
    });
    fixture = TestBed.createComponent(MeatTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
