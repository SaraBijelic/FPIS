import {RadnoMestoModel} from './radnoMesto.model';

export class OdeljenjeModel{
  odeljenjeID: number;
  nazivODeljenja: string;
  radnaMesta: RadnoMestoModel[];


  constructor() {
    this.odeljenjeID = null;
    this.nazivODeljenja = '';
    this.radnaMesta = null;
  }
}
