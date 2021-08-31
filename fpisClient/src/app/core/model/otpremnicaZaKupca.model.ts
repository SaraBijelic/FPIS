import {RadnikModel} from './radnik.model';
import {StavkaRacunaKupcaModel} from './stavkaRacunaKupca.model';
import {KupacModel} from './kupac.model';


export class OtpremnicaZaKupcaModel{

  otpremnicaZaKupcaID: number;
  otpremnicuPrimio: string;
  datumOtpremanja: Date;
  radnikDoprema: RadnikModel;
  kupacOtp: KupacModel;
  radnikKreirao: RadnikModel;


  constructor() {
    this.otpremnicaZaKupcaID = null;
    this.otpremnicuPrimio = '';
    this.datumOtpremanja = null;
    this.radnikDoprema = new RadnikModel();
    this.radnikKreirao = new RadnikModel();
    this.kupacOtp = new KupacModel();
  }
}
