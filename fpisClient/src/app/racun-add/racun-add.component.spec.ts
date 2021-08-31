import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RacunAddComponent } from './racun-add.component';

describe('RacunAddComponent', () => {
  let component: RacunAddComponent;
  let fixture: ComponentFixture<RacunAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RacunAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RacunAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
