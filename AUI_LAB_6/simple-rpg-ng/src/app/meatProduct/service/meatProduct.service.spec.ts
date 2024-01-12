import { TestBed } from '@angular/core/testing';

import { MeatProductService } from './meatProduct.service';

describe('MeatProduct', () => {
  let service: MeatProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MeatProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
