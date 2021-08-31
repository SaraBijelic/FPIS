import {KupacModel} from './kupac.model';
import {RadnikModel} from './radnik.model';
import {NacinPlacanjaModel} from './nacinPlacanja.model';
import {StavkeRacunaKupcaListModel} from './stavkeRacunaKupcaList.model';
import {AddUpdateStavkeRacunaListaModel} from './AddUpdateStavkeRacunaLista.model';

export class RacunKupcaModel{

  racunKupcaID : number;
  rokPlacanjaKupca : number;
  napomenaRacunaKupca : string;
  cenaRacuna : number;
  kupac : KupacModel;
  radnik : RadnikModel;
  otpremnicaRacunaID : number;
  nacinPlacanja : NacinPlacanjaModel;
  stavkaRacunaKupca : StavkeRacunaKupcaListModel;


  constructor() {
    this.racunKupcaID = null;
    this.rokPlacanjaKupca = null;
    this.napomenaRacunaKupca = null;
    this.cenaRacuna =  null;
    this.kupac = null;
    this.radnik = null;
    this.otpremnicaRacunaID = null;
    this.nacinPlacanja = null;
    this.stavkaRacunaKupca = new StavkeRacunaKupcaListModel();
  }
}
