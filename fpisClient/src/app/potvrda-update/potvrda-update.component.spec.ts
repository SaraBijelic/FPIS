import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotvrdaUpdateComponent } from './potvrda-update.component';

describe('PotvrdaUpdateComponent', () => {
  let component: PotvrdaUpdateComponent;
  let fixture: ComponentFixture<PotvrdaUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PotvrdaUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PotvrdaUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
