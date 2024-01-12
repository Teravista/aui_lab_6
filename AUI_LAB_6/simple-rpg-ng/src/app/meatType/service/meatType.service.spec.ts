import { TestBed } from '@angular/core/testing';

import { MeatTypeService } from './meatType.service';

describe('MeatTypeService', () => {
  let service: MeatTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MeatTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
