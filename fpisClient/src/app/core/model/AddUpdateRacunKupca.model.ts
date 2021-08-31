import {AddUpdateStavkaRacunaModel} from './AddUpdateStavkaRacuna.model';
import {AddUpdateStavkeRacunaListaModel} from './AddUpdateStavkeRacunaLista.model';

export class AddUpdateRacunKupcaModel{

  racunKupcaID : number;
  rokPlacanjaKupca : number;
  napomenaRacunaKupca : string;
  cenaRacuna : number;
  kupacID : number;
  radnikID : number;
  otpremnicaRacunaID : number;
  nacinPlacanjaID : number;
  stavkaRacunaKupca : AddUpdateStavkeRacunaListaModel;


  constructor() {
    this.racunKupcaID = null;
    this.rokPlacanjaKupca = null;
    this.napomenaRacunaKupca = null;
    this.cenaRacuna = null;
    this.kupacID = null;
    this.radnikID = null;
    this.otpremnicaRacunaID = null;
    this.stavkaRacunaKupca = new AddUpdateStavkeRacunaListaModel();
  }
}
