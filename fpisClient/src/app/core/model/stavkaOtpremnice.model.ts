import {OtpremnicaZaKupcaModel} from './otpremnicaZaKupca.model';
import {ProizvodModel} from './proizvod.model';

export class StavkaOtpremniceModel{


  stavkaOtpremniceZaKupcaID : number;
  otpremnicaZaKupca : OtpremnicaZaKupcaModel;
  kolicina : number;
  proizvodOtpremnice : ProizvodModel;


  constructor() {
    this.stavkaOtpremniceZaKupcaID = null;
    this.otpremnicaZaKupca = null;
    this.kolicina = null;
    this.proizvodOtpremnice = null;
  }
}
