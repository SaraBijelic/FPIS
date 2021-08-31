import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotvrdaAddComponent } from './potvrda-add.component';

describe('PotvrdaComponent', () => {
  let component: PotvrdaAddComponent;
  let fixture: ComponentFixture<PotvrdaAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PotvrdaAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PotvrdaAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
