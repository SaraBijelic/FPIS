import { ComponentFixture, TestBed } from '@angular/core/testing';
import {RacunUpdateComponent} from './racun-update.component';


describe('RacunUpdateComponent', () => {
  let component: RacunUpdateComponent;
  let fixture: ComponentFixture<RacunUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RacunUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RacunUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
