import {VeterinarModel} from './veterinar.model';
import {ProizvodModel} from './proizvod.model';
import {ZahtevModel} from './zahtevZaProveromKvaliteta.model';

export class PotvrdaModel {
  potvrdaOKvalitetuID: number;
  opisPotvrde: string;
  datumPotvrde: Date;
  vrstaRobe: string;
  mestoIzdavanja: string;
  veterinar: VeterinarModel;
  zahtev : ZahtevModel;
  proizvod: ProizvodModel;


  constructor() {
    this.potvrdaOKvalitetuID = null;
    this.opisPotvrde = '';
    this.datumPotvrde = null;
    this.vrstaRobe = '';
    this.mestoIzdavanja = '';
    this.veterinar = null;
    this.zahtev = null;
    this.proizvod = null;
  }
}
