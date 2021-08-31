import {RadnikModel} from './radnik.model';
import {OdeljenjeModel} from './odeljenje.model';

export class RadnoMestoModel{
  radnoMestoID: number;
  nazivRadnogMesta: string;
  opisRadnogMesta: string;
  radnici: RadnikModel[];
  odeljenje: OdeljenjeModel;


  constructor() {
    this.radnoMestoID = null;
    this.nazivRadnogMesta = '';
    this.opisRadnogMesta = '';
    this.radnici = [];
    this.odeljenje = null;
  }
}
