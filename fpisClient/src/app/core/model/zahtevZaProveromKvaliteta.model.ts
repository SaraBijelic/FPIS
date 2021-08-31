import {VeterinarModel} from './veterinar.model';
import {RadnikModel} from './radnik.model';
import {ProizvodModel} from './proizvod.model';

export class ZahtevModel{
  zahtevID: number;
  datum: Date;
  napomena: string;
  veterinar: VeterinarModel;
  radnik: RadnikModel;
  proizvod: ProizvodModel;


  constructor() {
    this.zahtevID = null;
    this.datum = null;
    this.napomena = '';
    this.veterinar = null;
    this.radnik = null;
    this.proizvod = null;

  }
}
