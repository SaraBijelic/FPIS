import {TipProizvodaModel} from './tipProizvoda.model';
import {JedinicaMereModel} from './jedinicaMere.model';

export class ProizvodModel{
  proizvodID: number;
  nazivProizvoda: string;
  datumProizvodnje: Date;
  cena: number;
  vrstaProizvoda: string;
  trenutnoStanjeZaliha: number;
  tipProizvoda: TipProizvodaModel;
  jedinicaMere: JedinicaMereModel;

  constructor() {
    this.proizvodID = null;
    this.nazivProizvoda = null;
    this.datumProizvodnje = null;
    this.cena = null;
    this.vrstaProizvoda = null;
    this.trenutnoStanjeZaliha = null;
    this.tipProizvoda = new TipProizvodaModel();
    this.jedinicaMere = new JedinicaMereModel();
  }
}
