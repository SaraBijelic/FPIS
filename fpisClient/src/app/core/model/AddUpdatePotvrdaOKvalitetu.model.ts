
export class AddUpdatePotvrdaOKvalitetuModel{

  potvrdaOKvalitetuID : number;
  opisPotvrde : string;
  datumPotvrde : Date;
  vrstaRobe : string;
  mestoIzdavanja : string;
  veterinarID : number;
  zahtevID : number;
  proizvodID : number;


  constructor() {
    this.potvrdaOKvalitetuID = null;
    this.opisPotvrde = '';
    this.datumPotvrde = null;
    this.vrstaRobe = '';
    this.mestoIzdavanja = '';
    this.veterinarID = null;
    this.zahtevID = null;
    this.proizvodID = null;
  }
}
