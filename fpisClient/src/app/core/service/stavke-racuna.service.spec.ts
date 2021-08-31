import { TestBed } from '@angular/core/testing';

import { StavkeRacunaService } from './stavke-racuna.service';

describe('StavkeRacunaService', () => {
  let service: StavkeRacunaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StavkeRacunaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
