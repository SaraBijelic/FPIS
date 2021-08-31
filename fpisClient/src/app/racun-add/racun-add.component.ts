
import {RacunKupcaModel} from '../core/model/racunKupca.model';
import {ToastrService} from 'ngx-toastr';
import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {RacunKupcaService} from '../core/service/racun-kupca.service';
import {MatTableDataSource} from '@angular/material/table';
import {StavkaRacunaKupcaModel} from '../core/model/stavkaRacunaKupca.model';
import {OtpremnicaZaKupcaModel} from '../core/model/otpremnicaZaKupca.model';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {ProizvodModel} from '../core/model/proizvod.model';
import {OtpremnicaListModel} from '../core/model/otpremnicaList.model';
import {OtpremnicaService} from '../core/service/otpremnica.service';
import {RacunKupcaListModel} from '../core/model/racunKupcaList.model';
import {JedinicaMereModel} from '../core/model/jedinicaMere.model';
import {AddUpdateRacunKupcaModel} from '../core/model/AddUpdateRacunKupca.model';
import {StavkeRacunaKupcaListModel} from '../core/model/stavkeRacunaKupcaList.model';
import {NacinPlacanjaModel} from '../core/model/nacinPlacanja.model';
import {NacinPlacanjaService} from '../core/service/nacin-placanja.service';
import {NacinPlacanjaListModel} from '../core/model/nacinPlacanjaList.model';
import {RadnikModel} from '../core/model/radnik.model';
import {RadnikListModel} from '../core/model/radnikList.model';
import {RadnikService} from '../core/service/radnik.service';
import {StavkeRacunaService} from '../core/service/stavke-racuna.service';
import {AddUpdateStavkaRacunaModel} from '../core/model/AddUpdateStavkaRacuna.model';
import {AddUpdateStavkeRacunaListaModel} from '../core/model/AddUpdateStavkeRacunaLista.model';

const FORMA = 'racun-add';
const FORMAP = 'add';
const RACUN = 'podaci';
const PROIZVOD = 'proizvod';
const STAVKE = 'stavke';
const IZMENA = 'idStavke';

@Component({
  selector: 'app-racun-add',
  templateUrl: './racun-add.component.html',
  styleUrls: ['./racun-add.component.css']
})
export class RacunAddComponent implements OnInit, AfterViewInit {

  novaStavka : StavkaRacunaKupcaModel = new StavkaRacunaKupcaModel();
  listaStavki : StavkeRacunaKupcaListModel = new StavkeRacunaKupcaListModel();
  dodataStavka : AddUpdateStavkaRacunaModel = new AddUpdateStavkaRacunaModel();
  novaListaStavki : AddUpdateStavkeRacunaListaModel = new AddUpdateStavkeRacunaListaModel();
  izmenaID : number = 0;

  biraniProizvod : ProizvodModel = new ProizvodModel();

  listaOtpremnica : OtpremnicaListModel = new OtpremnicaListModel();
  otpremnica : OtpremnicaZaKupcaModel = new OtpremnicaZaKupcaModel();

  listaRacuna : RacunKupcaListModel = new RacunKupcaListModel();
  racun : RacunKupcaModel = new RacunKupcaModel();
  noviRacun : AddUpdateRacunKupcaModel = new AddUpdateRacunKupcaModel();

  jedinicaMere : JedinicaMereModel = new JedinicaMereModel();

  selectedNaciniPlacanja : NacinPlacanjaModel = new NacinPlacanjaModel();
  naciniPlacanja : NacinPlacanjaListModel = new NacinPlacanjaListModel();

  selectedRadnik : RadnikModel = new RadnikModel();
  radnici: RadnikListModel = new RadnikListModel();

  idRacuna : number = null;
  ukupnaCenaStavki : number = null;

  displayedColumnsOtpremnica: string[] = [
    'otpremnicaID',
    'datum',
    'kupacID',
  ];

  displayedColumnsStavka: string[] = [
    'stavkaRacunaKupcaID',
    'kolicinaRobeZaPlacanje',
    'rabat',
    'proizvodID',
    'cenaSaPopustom',
    'nazivProizvoda'
  ];

  displayedColumnsPlacanja: string[] = [
    'nacinPlacanjaID',
    'nazivPlacanja'
  ];

  dataSource : MatTableDataSource<OtpremnicaZaKupcaModel> = new MatTableDataSource<OtpremnicaZaKupcaModel>();
  dataSourceS : MatTableDataSource<StavkaRacunaKupcaModel> = new MatTableDataSource<StavkaRacunaKupcaModel>();
  dataSourceNacinPlacanja : MatTableDataSource<NacinPlacanjaModel> = new MatTableDataSource<NacinPlacanjaModel>();
  clickedRow : StavkaRacunaKupcaModel = new StavkaRacunaKupcaModel();
  clickedRows : Set<StavkaRacunaKupcaModel> = new Set<StavkaRacunaKupcaModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private racunKupcaService : RacunKupcaService, private otpremniceService : OtpremnicaService,
              private nacinPlacanjaService : NacinPlacanjaService, private radnikService : RadnikService,
              private stavkeRacunaService : StavkeRacunaService, private toastr: ToastrService) {}

  ngOnInit(): void {
    this.getNacinPlacanja();
    this.getRadnik();
    this.getRacuni();
    this.getOtpremnice();
    this.izabraniProizvod();
    this.prikaziStavke();
  }

  ngAfterViewInit() {
    this.dataSourceS.paginator = this.paginator;
    this.dataSourceS.sort = this.sort;
  }

  dodajNacinPlacanja(selectedValue: NacinPlacanjaModel) {
    if(selectedValue.nacinPlacanjaID === null) this.toastr.info("Izberite nacin placanja");
    else {
      this.dataSourceNacinPlacanja.data = [selectedValue];
      this.racun.nacinPlacanja = selectedValue;
    }
  }

  onClick(parametar : StavkaRacunaKupcaModel) {
    this.clickedRow = parametar;
    this.clickedRows = new Set<StavkaRacunaKupcaModel>();
    this.clickedRows[0] = parametar;
  }

  equals(objOne, objTwo) {
    if (typeof objOne !== 'undefined' && typeof objTwo !== 'undefined') {
      return objOne.nacinPlacanjaID === objTwo.nacinPlacanjaID;
    }
  }

  equalsRadnik(objOne, objTwo) {
    if (typeof objOne !== 'undefined' && typeof objTwo !== 'undefined') {
      return objOne.radnikID === objTwo.radnikID;
    }
  }

  getNacinPlacanja(){
    this.nacinPlacanjaService.getAllNaciniPlacanja().subscribe(
      data => {
        this.naciniPlacanja = data;
      },
      error => {
        this.toastr.error("Failed to get nacini placanja");
      }
    );
  }

  getRadnik(){
    this.radnikService.getAllRadnik().subscribe(
      data => {
        this.radnici = data;
      },
      error => {
        this.toastr.error("Failed to get radnici");
      }
    );
  }

  getRacuni() {

    this.racunKupcaService.getAllRacuni().subscribe(
      data => {
        this.listaRacuna = data;
        let max = 0;
        for(var i = 0; i < this.listaRacuna.racuni.length; i++)
        {
          if(this.listaRacuna.racuni[i].racunKupcaID > max){
            max = this.listaRacuna.racuni[i].racunKupcaID;
          }
        }
        this.idRacuna = max+1;

        if(JSON.parse(localStorage.getItem(RACUN)) !== null) {
          this.racun = JSON.parse(localStorage.getItem(RACUN));
          if(this.racun.nacinPlacanja !== null) this.dataSourceNacinPlacanja.data = [this.racun.nacinPlacanja];
        }
      },
      error => {
        this.idRacuna = 1;
        if(JSON.parse(localStorage.getItem(RACUN)) !== null) {
          this.racun = JSON.parse(localStorage.getItem(RACUN));
          if(this.racun.nacinPlacanja !== null) this.dataSourceNacinPlacanja.data = [this.racun.nacinPlacanja];
        }
        this.toastr.error("Failed to get racuni");
      }
    );
  }

  izmeniStavku() {

    if(this.clickedRow.stavkaRacunaKupcaID === null) {
      this.toastr.info("Izaberite stavku");
      return;
    }
    this.novaStavka = this.clickedRow;
    this.izmenaID = this.clickedRow.stavkaRacunaKupcaID;
    localStorage.removeItem(IZMENA);
    localStorage.setItem(IZMENA, JSON.stringify(this.izmenaID));
    this.obrisiStavku();
    this.biraniProizvod = this.novaStavka.proizvodStavkeRacuna;

  }

  private getOtpremnice() {
    if(JSON.parse(localStorage.getItem(FORMA)) !== null){
      this.otpremnica = JSON.parse(localStorage.getItem(FORMA));
      this.dataSource.data = [this.otpremnica];
      this.noviRacun.otpremnicaRacunaID = this.otpremnica.otpremnicaZaKupcaID;
    }
  }

  formaOtpremnica() {
    localStorage.removeItem(RACUN);
    localStorage.setItem(RACUN, JSON.stringify(this.racun));

    localStorage.removeItem(PROIZVOD);
    localStorage.setItem(PROIZVOD, JSON.stringify(this.biraniProizvod));

    localStorage.removeItem(STAVKE);
    localStorage.setItem(STAVKE, JSON.stringify(this.dataSourceS.data));

    localStorage.removeItem(FORMA);
    localStorage.setItem('formaOtpremnice', JSON.stringify(FORMA));
  }

  formaProizvoda() {
    localStorage.removeItem(RACUN);
    localStorage.setItem(RACUN, JSON.stringify(this.racun));

    localStorage.removeItem(FORMA);
    localStorage.setItem(FORMA, JSON.stringify(this.otpremnica));

    localStorage.removeItem(STAVKE);
    localStorage.setItem(STAVKE, JSON.stringify(this.dataSourceS.data));

    localStorage.removeItem(FORMAP);
    localStorage.setItem('formaProizvoda', JSON.stringify(FORMAP));
  }

  izabraniProizvod(){
    this.jedinicaMere = new JedinicaMereModel();
    this.biraniProizvod.jedinicaMere = this.jedinicaMere;

    if(JSON.parse(localStorage.getItem(FORMAP)) !== null){
      this.biraniProizvod = JSON.parse(localStorage.getItem(FORMAP));
    }
  }

  prikaziStavke(){
    if(JSON.parse(localStorage.getItem(STAVKE)) !== null){
      this.listaStavki.stavke = JSON.parse(localStorage.getItem(STAVKE));
      this.dataSourceS.data = this.listaStavki.stavke;
    }
  }

  dodajStavku() {
    if(JSON.parse(localStorage.getItem(IZMENA)) !== null){
      this.izmenaID = JSON.parse(localStorage.getItem(IZMENA));
    }
    if(this.novaStavka.kolicinaRobeZaPlacanje === null) {
      this.toastr.info("Unesite kolicinu robe");
    }else if(this.novaStavka.rabat === null){
      this.toastr.info("Unesite rabat");
    }else if(this.novaStavka.cenaSaPopustom === null){
      this.toastr.info("Izracunajte cenu stavke");
    }else if(this.biraniProizvod === null){
      this.toastr.info("Izaberite proizvod");
    }else{
      if(this.izmenaID !== 0) {
        this.novaStavka.stavkaRacunaKupcaID = this.izmenaID;
      }else{
        let max = 0;
        if(this.listaStavki.stavke !== []) {
          for (var i = 0; i < this.listaStavki.stavke.length; i++) {
            if (this.listaStavki.stavke[i].stavkaRacunaKupcaID > max) {
              max = this.listaStavki.stavke[i].stavkaRacunaKupcaID;
            }
          }
        }
        this.novaStavka.stavkaRacunaKupcaID = max + 1;
      }
      this.novaStavka.proizvodStavkeRacuna = this.biraniProizvod;
      this.novaStavka.racunKupca.racunKupcaID = this.idRacuna;
      this.listaStavki.stavke.push(this.novaStavka);
      this.dataSourceS.data = this.listaStavki.stavke;
      this.novaStavka = new StavkaRacunaKupcaModel();
      this.jedinicaMere = new JedinicaMereModel();
      this.biraniProizvod = new ProizvodModel();
      this.biraniProizvod.jedinicaMere = this.jedinicaMere;
      this.izmenaID = 0;
      localStorage.removeItem(IZMENA);
    }
  }

  izracunajCenu() {

    if(this.novaStavka.kolicinaRobeZaPlacanje === null) {
      this.toastr.info("Unesite kolicinu robe");
    }else if(this.novaStavka.rabat === null){
      this.toastr.info("Unesite rabat");
    }else if(this.biraniProizvod === null){
      this.toastr.info("Izaberite proizvod");
    }else{
      this.novaStavka.cenaSaPopustom = (this.biraniProizvod.cena*(100-this.novaStavka.rabat)/100)
        *this.novaStavka.kolicinaRobeZaPlacanje;
      this.toastr.success("Cena stavke je: "+this.novaStavka.cenaSaPopustom);
    }
  }

  obrisiStavku() {

    if(this.clickedRow.stavkaRacunaKupcaID === null) {
      this.toastr.info("Izaberite stavku");
      return;
    }

    this.listaStavki.stavke = this.dataSourceS.data;
    this.listaStavki.stavke.forEach( (item, index) => {
      if(item === this.clickedRow) this.listaStavki.stavke.splice(index,1);
    });
    this.dataSourceS.data = this.listaStavki.stavke;
  }

  ukupnaCena() {
    this.ukupnaCenaStavki = 0;
    for (var i = 0; i < this.listaStavki.stavke.length; i++) {
      this.ukupnaCenaStavki = this.ukupnaCenaStavki+this.listaStavki.stavke[i].cenaSaPopustom;
    }
    this.racun.cenaRacuna = this.ukupnaCenaStavki;
  }

  sacuvajRacun() {

    if(this.racun.rokPlacanjaKupca === null) {
      this.toastr.info("Unesite rok placanja");
    }else if(this.racun.nacinPlacanja === null){
      this.toastr.info("Unesite nacin placanja");
    }else if(this.dataSource.data === null){
      this.toastr.info("Izaberite otpremnicu");
    }else if(this.dataSourceS.data === null){
      this.toastr.info("Unesite stavku");
    }else if(this.racun.cenaRacuna === null){
      this.toastr.info("Izdracunajte cenu racuna");
    }else if(this.selectedRadnik.imePrezime === null){
      this.toastr.info("Izaberite radnika");
    }else{
      this.noviRacun.racunKupcaID = this.idRacuna;
      this.noviRacun.rokPlacanjaKupca = this.racun.rokPlacanjaKupca;
      this.noviRacun.napomenaRacunaKupca = this.racun.napomenaRacunaKupca;
      this.noviRacun.nacinPlacanjaID = this.racun.nacinPlacanja.nacinPlacanjaID;
      this.noviRacun.otpremnicaRacunaID = this.racun.otpremnicaRacunaID;

      this.listaStavki.stavke = this.dataSourceS.data;
      this.noviRacun.cenaRacuna = this.racun.cenaRacuna;
      this.noviRacun.radnikID = this.selectedRadnik.radnikID;
      this.otpremnica = this.dataSource.data[0];
      this.noviRacun.otpremnicaRacunaID = this.otpremnica.otpremnicaZaKupcaID;
      this.noviRacun.kupacID = this.otpremnica.kupacOtp.kupacID;
      this.novaListaStavki = new AddUpdateStavkeRacunaListaModel();
      for (var i = 0; i < this.listaStavki.stavke.length; i++) {
        this.dodataStavka = new AddUpdateStavkaRacunaModel();
        this.dodataStavka.stavkaRacunaKupcaID = this.listaStavki.stavke[i].stavkaRacunaKupcaID;
        this.dodataStavka.racunKupcaID = this.listaStavki.stavke[i].racunKupca.racunKupcaID;
        this.dodataStavka.kolicinaRobeZaPlacanje = this.listaStavki.stavke[i].kolicinaRobeZaPlacanje;
        this.dodataStavka.rabat = this.listaStavki.stavke[i].rabat;
        this.dodataStavka.cenaSaPopustom = this.listaStavki.stavke[i].cenaSaPopustom;
        this.dodataStavka.proizvodStavkeRacunaID = this.listaStavki.stavke[i].proizvodStavkeRacuna.proizvodID;

        this.novaListaStavki.stavkeList.push(this.dodataStavka);
      }
      this.noviRacun.stavkaRacunaKupca = this.novaListaStavki;
      this.racunKupcaService.addRacun(this.noviRacun).subscribe( data =>
      {this.toastr.success("Racun je uspesno zapamcen")

        localStorage.removeItem(FORMAP);
        localStorage.removeItem(FORMA);
        localStorage.removeItem(RACUN);
        localStorage.removeItem(PROIZVOD);
        localStorage.removeItem(STAVKE);

        this.idRacuna = this.noviRacun.racunKupcaID+1;
        this.ukupnaCenaStavki = null;
        this.racun = new RacunKupcaModel();
        this.selectedRadnik = new RadnikModel();
        this.noviRacun = new AddUpdateRacunKupcaModel();
        this.dataSource = new MatTableDataSource<OtpremnicaZaKupcaModel>();
        this.dataSourceS = new MatTableDataSource<StavkaRacunaKupcaModel>();
        this.dataSourceNacinPlacanja = new MatTableDataSource<NacinPlacanjaModel>();
      }, error => {this.toastr.error("Racun nije zapamcen")});
    }
  }
  odustaniOdRacuna() {
    localStorage.removeItem(FORMAP);
    localStorage.removeItem(FORMA);
    localStorage.removeItem(RACUN);
    localStorage.removeItem(PROIZVOD);
    localStorage.removeItem(STAVKE);
  }
}
