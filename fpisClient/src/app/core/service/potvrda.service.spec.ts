import {PotvrdaService} from './potvrda.service';
import {TestBed} from '@angular/core/testing';

describe('PotvrdaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PotvrdaService = TestBed.get(PotvrdaService);
    expect(service).toBeTruthy();
  });
});
