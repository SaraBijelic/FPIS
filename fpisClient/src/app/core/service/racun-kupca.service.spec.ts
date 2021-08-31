import { TestBed } from '@angular/core/testing';

import { RacunKupcaService } from './racun-kupca.service';

describe('RacunKupcaService', () => {
  let service: RacunKupcaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RacunKupcaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
