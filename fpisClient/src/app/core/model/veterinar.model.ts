export class VeterinarModel {
  veterinarID: number;
  nazivFirme: string;
  pib: string;
  maticniBr: string;
  ziroRacun: string;
  email: string;
  webSite: string;

  constructor() {
    this.veterinarID = null;
    this.nazivFirme = '';
    this.pib = '';
    this.maticniBr = '';
    this.ziroRacun = '';
    this.email = '';
    this.webSite = '';
  }
}
