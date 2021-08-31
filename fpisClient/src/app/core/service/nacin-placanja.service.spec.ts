import { TestBed } from '@angular/core/testing';

import { NacinPlacanjaService } from './nacin-placanja.service';

describe('NacinPlacanjaService', () => {
  let service: NacinPlacanjaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NacinPlacanjaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
