import {RacunKupcaModel} from './racunKupca.model';
import {ProizvodModel} from './proizvod.model';

export class StavkaRacunaKupcaModel{

  stavkaRacunaKupcaID : number;
  racunKupca : RacunKupcaModel;
  kolicinaRobeZaPlacanje : number;
  rabat : number;
  cenaSaPopustom : number;
  proizvodStavkeRacuna : ProizvodModel;


  constructor() {
    this.stavkaRacunaKupcaID = null;
    this.racunKupca = new RacunKupcaModel();
    this.kolicinaRobeZaPlacanje = null;
    this.rabat = null;
    this.cenaSaPopustom = null;
    this.proizvodStavkeRacuna = new ProizvodModel();
  }
}
