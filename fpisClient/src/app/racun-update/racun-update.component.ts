import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {RacunKupcaModel} from '../core/model/racunKupca.model';
import {ToastrService} from 'ngx-toastr';
import {RacunKupcaService} from '../core/service/racun-kupca.service';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {RacunKupcaListModel} from '../core/model/racunKupcaList.model';
import {StavkaRacunaKupcaModel} from '../core/model/stavkaRacunaKupca.model';
import {FormControl} from '@angular/forms';
import {OtpremnicaZaKupcaModel} from '../core/model/otpremnicaZaKupca.model';
import {OtpremnicaListModel} from '../core/model/otpremnicaList.model';
import {OtpremnicaService} from '../core/service/otpremnica.service';
import {ProizvodModel} from '../core/model/proizvod.model';
import {NacinPlacanjaService} from '../core/service/nacin-placanja.service';
import {NacinPlacanjaModel} from '../core/model/nacinPlacanja.model';
import {NacinPlacanjaListModel} from '../core/model/nacinPlacanjaList.model';
import {JedinicaMereModel} from '../core/model/jedinicaMere.model';
import {StavkeRacunaKupcaListModel} from '../core/model/stavkeRacunaKupcaList.model';
import {RadnikModel} from '../core/model/radnik.model';
import {RadnikListModel} from '../core/model/radnikList.model';
import {RadnikService} from '../core/service/radnik.service';
import {AddUpdateRacunKupcaModel} from '../core/model/AddUpdateRacunKupca.model';
import {StavkeRacunaService} from '../core/service/stavke-racuna.service';
import {AddUpdateStavkeRacunaListaModel} from '../core/model/AddUpdateStavkeRacunaLista.model';
import {AddUpdateStavkaRacunaModel} from '../core/model/AddUpdateStavkaRacuna.model';
import {PotvrdaModel} from '../core/model/potvrdaOKvalitetu.model';
import {AddUpdatePotvrdaOKvalitetuModel} from '../core/model/AddUpdatePotvrdaOKvalitetu.model';
import {ZahtevModel} from '../core/model/zahtevZaProveromKvaliteta.model';

interface RacunKreirao {
  value: string;
  viewValue: string;
}
const FORMA = 'racun-update';
const FORMAP = 'update';
const RACUN = 'podaci';
const PROIZVOD = 'proizvod';
const STAVKE = 'stavke';
const IZMENA = 'idStavke';

@Component({
  selector: 'app-racun-update',
  templateUrl: './racun-update.component.html',
  styleUrls: ['./racun-update.component.css']
})
export class RacunUpdateComponent implements OnInit, AfterViewInit {

  listaRacuna : RacunKupcaListModel = new RacunKupcaListModel();
  racun : RacunKupcaModel = new RacunKupcaModel();
  izmenjeniRacun : AddUpdateRacunKupcaModel = new AddUpdateRacunKupcaModel();

  izmenjenaStavka : StavkaRacunaKupcaModel = new StavkaRacunaKupcaModel();
  listaStavki : StavkeRacunaKupcaListModel = new StavkeRacunaKupcaListModel();
  izmenjenaListaStavki : AddUpdateStavkeRacunaListaModel = new AddUpdateStavkeRacunaListaModel();
  dodataStavka : AddUpdateStavkaRacunaModel = new AddUpdateStavkaRacunaModel();

  biraniProizvod : ProizvodModel = new ProizvodModel();
  izmenaID : number = 0;

  jedinicaMere : JedinicaMereModel = new JedinicaMereModel();
  ukupnaCenaStavki : number = null;

  idFilter = new FormControl('');
  rokFilter = new FormControl('');

  listaOtpremnica : OtpremnicaListModel = new OtpremnicaListModel();
  otpremnica : OtpremnicaZaKupcaModel = new OtpremnicaZaKupcaModel();

  selectedNaciniPlacanja : NacinPlacanjaModel = new NacinPlacanjaModel();
  naciniPlacanja : NacinPlacanjaListModel = new NacinPlacanjaListModel();

  selectedValueRacun: string;
  selectedRadnik : RadnikModel = new RadnikModel();
  radnici: RadnikListModel = new RadnikListModel();

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

  displayedColumnsRacun: string[] = [
    'racunKupcaID',
    'rokPlacanjaKupca',
    'napomenaRacunaKupca',
    'kupac',
    'radnik',
    'otpremnicaZaKupca'
  ];

  displayedColumnsPlacanja: string[] = [
    'nacinPlacanjaID',
    'nazivPlacanja'
  ];

  filterValues = {
    racunKupcaID: '',
    rokPlacanjaKupca: ''
  };

  dataSourceO : MatTableDataSource<OtpremnicaZaKupcaModel> = new MatTableDataSource<OtpremnicaZaKupcaModel>();
  dataSourceS : MatTableDataSource<StavkaRacunaKupcaModel> = new MatTableDataSource<StavkaRacunaKupcaModel>();
  dataSourceR : MatTableDataSource<RacunKupcaModel> = new MatTableDataSource<RacunKupcaModel>();
  dataSourceNacinPlacanja : MatTableDataSource<NacinPlacanjaModel> = new MatTableDataSource<NacinPlacanjaModel>();
  clickedRow : RacunKupcaModel = new RacunKupcaModel();
  clickedRows : Set<RacunKupcaModel> = new Set<RacunKupcaModel>();
  clickedRowStavka : StavkaRacunaKupcaModel = new StavkaRacunaKupcaModel();
  clickedRowsStavke : Set<StavkaRacunaKupcaModel> = new Set<StavkaRacunaKupcaModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private racunKupcaService : RacunKupcaService, private otpremniceService : OtpremnicaService,
              private nacinPlacanjaService : NacinPlacanjaService, private radnikService : RadnikService,
              private stavkeRacunaService : StavkeRacunaService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getNacinPlacanja();
    this.getRadnik();
    this.getRacuni();
    this.getOtpremnice();
    this.izabraniProizvod();
    this.applyFilter();
    this.getAllOtpremnice();
    this.prikaziStavke();
  }

  ngAfterViewInit() {
    this.dataSourceR.paginator = this.paginator;
    this.dataSourceR.sort = this.sort;
  }

  public onClick(parametar : RacunKupcaModel){
    this.clickedRow = parametar;
    this.clickedRows = new Set<RacunKupcaModel>();
    this.clickedRows[0] = parametar;
    this.getOneOtpremnice(this.clickedRow.otpremnicaRacunaID)
  }

  public equals(objOne, objTwo) {
    if (typeof objOne !== 'undefined' && typeof objTwo !== 'undefined') {
      return objOne.nacinPlacanjaID === objTwo.nacinPlacanjaID;
    }
  }

  public equalsRadnik(objOne, objTwo) {
    if (typeof objOne !== 'undefined' && typeof objTwo !== 'undefined') {
      return objOne.radnikID === objTwo.radnikID;
    }
  }

  public getRacuni() {

    this.racunKupcaService.getAllRacuni().subscribe(
      data => {
        this.listaRacuna = data;
        this.dataSourceR.data = this.listaRacuna.racuni;
        if(JSON.parse(localStorage.getItem(RACUN)) !== null) {
          this.racun = JSON.parse(localStorage.getItem(RACUN));
          if(this.racun.nacinPlacanja !== null) this.dataSourceNacinPlacanja.data = [this.racun.nacinPlacanja];
        }
        },error => {
        if(JSON.parse(localStorage.getItem(RACUN)) !== null) {
          this.racun = JSON.parse(localStorage.getItem(RACUN));
          if(this.racun.nacinPlacanja !== null) this.dataSourceNacinPlacanja.data = [this.racun.nacinPlacanja];
        }
        this.toastr.error("Failed to get racuni");
      }
    );
  }

  private getOtpremnice() {
    if(JSON.parse(localStorage.getItem(FORMA)) !== null){
      this.otpremnica = JSON.parse(localStorage.getItem(FORMA));
      this.dataSourceO.data = [this.otpremnica];
      this.izmenjeniRacun.otpremnicaRacunaID = this.otpremnica.otpremnicaZaKupcaID;
    }
  }

  public dodajNacinPlacanja(selectedValue: NacinPlacanjaModel) {
    if(selectedValue.nacinPlacanjaID === null) this.toastr.info("Izberite nacin placanja");
    else {
      this.dataSourceNacinPlacanja.data = [selectedValue];
      this.racun.nacinPlacanja = selectedValue;
    }
  }

  public izabraniRacun() {
    if(this.clickedRow === null) {
      return;
    }else{
      this.racun.racunKupcaID = this.clickedRow.racunKupcaID;
      this.izmenjeniRacun.racunKupcaID = this.racun.racunKupcaID;
      this.getStavkeRacunaIDRacuna(this.racun.racunKupcaID);
      this.racun.stavkaRacunaKupca.stavke = this.dataSourceS.data;
      this.racun.rokPlacanjaKupca = this.clickedRow.rokPlacanjaKupca;
      this.racun.kupac = this.clickedRow.kupac;
      this.racun.napomenaRacunaKupca = this.clickedRow.napomenaRacunaKupca;
      this.racun.otpremnicaRacunaID = this.clickedRow.otpremnicaRacunaID;
      this.racun.radnik = this.clickedRow.radnik;
      this.racun.nacinPlacanja = this.clickedRow.nacinPlacanja;
      this.dataSourceNacinPlacanja.data = [this.racun.nacinPlacanja];
      this.getOneOtpremnice(this.racun.otpremnicaRacunaID)
    }

  }

  public applyFilter() {
    this.dataSourceR.filterPredicate = this.createFilter();
    this.idFilter.valueChanges.subscribe(racunKupcaID => {
              this.filterValues.racunKupcaID = racunKupcaID;
              this.dataSourceR.filter = JSON.stringify(this.filterValues);
            }
        )
    this.rokFilter.valueChanges.subscribe(rokPlacanjaKupca => {
              this.filterValues.rokPlacanjaKupca = rokPlacanjaKupca;
              this.dataSourceR.filter = JSON.stringify(this.filterValues);
            }
        )
  }

  public createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.racunKupcaID.toString().toLowerCase().indexOf(searchTerms.racunKupcaID) !== -1
          && data.rokPlacanjaKupca.toString().toLowerCase().indexOf(searchTerms.rokPlacanjaKupca) !== -1
    }
    return filterFunction;
  }

  private getAllOtpremnice() {
    this.otpremniceService.getAllOtpremnica().subscribe(
        data => {
          this.listaOtpremnica = data;
        },
        error => {
          this.toastr.error("Failed to get otpremnice");
        }
    );
  }
  private getOneOtpremnice(id : number) {
    this.otpremniceService.getOneOtpremnica(id).subscribe(
        data => {
          this.otpremnica = data;
          this.dataSourceO.data = [this.otpremnica];
        }, error => {
          this.toastr.error("Failed to get otpremnica");
        }
    );
  }

  public izmeniStavku() {
    if(this.clickedRowStavka.stavkaRacunaKupcaID === null) {
      this.toastr.info("Izaberite stavku");
      return;
    }
    this.izmenjenaStavka = this.clickedRowStavka;
    this.izmenaID = this.clickedRowStavka.stavkaRacunaKupcaID;
    localStorage.removeItem(IZMENA);
    localStorage.setItem(IZMENA, JSON.stringify(this.izmenaID));
    this.obrisiStavku();
    this.biraniProizvod = this.izmenjenaStavka.proizvodStavkeRacuna;
  }

  public onClickStavka(parametar: StavkaRacunaKupcaModel) {
    this.clickedRowStavka = parametar;
    this.clickedRowsStavke = new Set<StavkaRacunaKupcaModel>();
  }

  private getNacinPlacanja() {
    this.nacinPlacanjaService.getAllNaciniPlacanja().subscribe(
      data => {
        this.naciniPlacanja = data;
      },
      error => {
        this.toastr.error("Failed to get nacini placanja");
      }
    );
  }

  public formaOtpremnica() {
    localStorage.removeItem(RACUN);
    localStorage.setItem(RACUN, JSON.stringify(this.racun));

    localStorage.removeItem(PROIZVOD);
    localStorage.setItem(PROIZVOD, JSON.stringify(this.biraniProizvod));

    localStorage.removeItem(STAVKE);
    localStorage.setItem(STAVKE, JSON.stringify(this.dataSourceS.data));

    localStorage.removeItem(IZMENA);
    localStorage.setItem(IZMENA, JSON.stringify(this.izmenaID));

    localStorage.removeItem(FORMA);
    localStorage.setItem('formaOtpremnice', JSON.stringify(FORMA));
  }

  public formaProizvoda() {
    localStorage.removeItem(RACUN);
    localStorage.setItem(RACUN, JSON.stringify(this.racun));

    localStorage.removeItem(FORMA);
    localStorage.setItem(FORMA, JSON.stringify(this.otpremnica));

    localStorage.removeItem(STAVKE);
    localStorage.setItem(STAVKE, JSON.stringify(this.dataSourceS.data));

    localStorage.removeItem(IZMENA);
    localStorage.setItem(IZMENA, JSON.stringify(this.izmenaID));

    localStorage.removeItem(FORMAP);
    localStorage.setItem('formaProizvoda', JSON.stringify(FORMAP));
  }

  public dodajStavku() {
    if(JSON.parse(localStorage.getItem(IZMENA)) !== null){
      this.izmenaID = JSON.parse(localStorage.getItem(IZMENA));
    }
    if(this.izmenjenaStavka.kolicinaRobeZaPlacanje === null) {
      this.toastr.info("Unesite kolicinu robe");
    }else if(this.izmenjenaStavka.rabat === null){
      this.toastr.info("Unesite rabat");
    }else if(this.izmenjenaStavka.cenaSaPopustom === null){
      this.toastr.info("Izracunajte cenu stavke");
    }else if(this.biraniProizvod === null){
      this.toastr.info("Izaberite proizvod");
    }else{
      if(this.izmenaID !== 0) {
        this.izmenjenaStavka.stavkaRacunaKupcaID = this.izmenaID;
      }else{
        let max = 0;
        if(this.listaStavki.stavke !== []) {
          for (var i = 0; i < this.listaStavki.stavke.length; i++) {
            if (this.listaStavki.stavke[i].stavkaRacunaKupcaID > max) {
              max = this.listaStavki.stavke[i].stavkaRacunaKupcaID;
            }
          }
        }
        this.izmenjenaStavka.stavkaRacunaKupcaID = max + 1;
      }
      this.izmenjenaStavka.proizvodStavkeRacuna = this.biraniProizvod;

      this.listaStavki.stavke.push(this.izmenjenaStavka);
      this.dataSourceS.data = this.listaStavki.stavke;
      this.izmenjenaStavka = new StavkaRacunaKupcaModel();
      this.jedinicaMere = new JedinicaMereModel();
      this.biraniProizvod = new ProizvodModel();
      this.biraniProizvod.jedinicaMere = this.jedinicaMere;
      this.izmenaID = 0;
      localStorage.removeItem(IZMENA);
    }
  }

  private getRadnik() {
    this.radnikService.getAllRadnik().subscribe(
      data => {
        this.radnici = data;
      },
      error => {
        this.toastr.error("Failed to get radnici");
      }
    );
  }

  public getStavkeRacunaIDRacuna(id : number){
    this.stavkeRacunaService.getStavkeRacunaIDRacuna(id).subscribe(
      data => {
        this.listaStavki = data;
        this.dataSourceS.data = this.listaStavki.stavke;
      }, error => {
        this.toastr.error("Failed to get Stavke");
      }
    );
  }

  public prikaziStavke(){
    if(JSON.parse(localStorage.getItem(STAVKE)) !== null){
      this.listaStavki.stavke = JSON.parse(localStorage.getItem(STAVKE));
      this.dataSourceS.data = this.listaStavki.stavke;
    }
  }

  private izabraniProizvod() {
    this.jedinicaMere = new JedinicaMereModel();
    this.biraniProizvod.jedinicaMere = this.jedinicaMere;

    if(JSON.parse(localStorage.getItem(FORMAP)) !== null){
      this.biraniProizvod = JSON.parse(localStorage.getItem(FORMAP));
    }
  }

  public izracunajCenu() {
    if(this.izmenjenaStavka.kolicinaRobeZaPlacanje === null) {
      this.toastr.info("Unesite kolicinu robe");
    }else if(this.izmenjenaStavka.rabat === null){
      this.toastr.info("Unesite rabat");
    }else if(this.biraniProizvod === null){
      this.toastr.info("Izaberite proizvod");
    }else{
      this.izmenjenaStavka.cenaSaPopustom = (this.biraniProizvod.cena*(100-this.izmenjenaStavka.rabat)/100)
        *this.izmenjenaStavka.kolicinaRobeZaPlacanje;
      this.toastr.success("Cena stavke je: "+this.izmenjenaStavka.cenaSaPopustom);
    }
  }

  public obrisiStavku() {

    if(this.clickedRowStavka.stavkaRacunaKupcaID === null) {
      this.toastr.info("Izaberite stavku");
      return;
    }

    this.listaStavki.stavke = this.dataSourceS.data;
    this.listaStavki.stavke.forEach( (item, index) => {
      if(item === this.clickedRowStavka) this.listaStavki.stavke.splice(index,1);
    });
    this.dataSourceS.data = this.listaStavki.stavke;

  }

  public ukupnaCena() {
    this.ukupnaCenaStavki = 0;
    for (var i = 0; i < this.listaStavki.stavke.length; i++) {
      this.ukupnaCenaStavki = this.ukupnaCenaStavki+this.listaStavki.stavke[i].cenaSaPopustom;
    }
    this.racun.cenaRacuna = this.ukupnaCenaStavki;
  }

  public sacuvajRacun() {
    if(this.racun.rokPlacanjaKupca === null) {
      this.toastr.info("Unesite rok placanja");
    }else if(this.racun.nacinPlacanja === null){
      this.toastr.info("Unesite nacin placanja");
    }else if(this.dataSourceO.data === null){
      this.toastr.info("Izaberite otpremnicu");
    }else if(this.dataSourceS.data === null){
      this.toastr.info("Unesite stavku");
    }else if(this.racun.cenaRacuna === null){
      this.toastr.info("Izdracunajte cenu racuna");
    }else if(this.selectedRadnik.imePrezime === null){
      this.toastr.info("Izaberite radnika");
    }else{
      this.izmenjeniRacun.racunKupcaID = this.racun.racunKupcaID;
      this.izmenjeniRacun.rokPlacanjaKupca = this.racun.rokPlacanjaKupca;
      this.izmenjeniRacun.napomenaRacunaKupca = this.racun.napomenaRacunaKupca;
      this.izmenjeniRacun.nacinPlacanjaID = this.racun.nacinPlacanja.nacinPlacanjaID;
      this.izmenjeniRacun.otpremnicaRacunaID = this.racun.otpremnicaRacunaID;

      this.listaStavki.stavke = this.dataSourceS.data;
      this.izmenjeniRacun.cenaRacuna = this.racun.cenaRacuna;
      this.izmenjeniRacun.radnikID = this.selectedRadnik.radnikID;
      this.otpremnica = this.dataSourceO.data[0];
      this.izmenjeniRacun.otpremnicaRacunaID = this.otpremnica.otpremnicaZaKupcaID;
      this.izmenjeniRacun.kupacID = this.otpremnica.kupacOtp.kupacID;
      this.izmenjenaListaStavki = new AddUpdateStavkeRacunaListaModel();
      for (var i = 0; i < this.listaStavki.stavke.length; i++) {
        this.dodataStavka = new AddUpdateStavkaRacunaModel();
        this.dodataStavka.stavkaRacunaKupcaID = this.listaStavki.stavke[i].stavkaRacunaKupcaID;
        this.dodataStavka.racunKupcaID = this.listaStavki.stavke[i].racunKupca.racunKupcaID;
        this.dodataStavka.kolicinaRobeZaPlacanje = this.listaStavki.stavke[i].kolicinaRobeZaPlacanje;
        this.dodataStavka.rabat = this.listaStavki.stavke[i].rabat;
        this.dodataStavka.cenaSaPopustom = this.listaStavki.stavke[i].cenaSaPopustom;
        this.dodataStavka.proizvodStavkeRacunaID = this.listaStavki.stavke[i].proizvodStavkeRacuna.proizvodID;

        this.izmenjenaListaStavki.stavkeList.push(this.dodataStavka);
      }
      this.izmenjeniRacun.stavkaRacunaKupca = this.izmenjenaListaStavki;
      this.racunKupcaService.updateRacunKupca(this.izmenjeniRacun).subscribe( data =>
      {this.toastr.success("Racun je uspesno zapamcen")

        localStorage.removeItem(FORMAP);
        localStorage.removeItem(FORMA);
        localStorage.removeItem(RACUN);
        localStorage.removeItem(PROIZVOD);
        localStorage.removeItem(STAVKE);

        this.racun.racunKupcaID = this.izmenjeniRacun.racunKupcaID+1;
        this.ukupnaCenaStavki = null;
        this.racun = new RacunKupcaModel();
        this.selectedRadnik = new RadnikModel();
        this.izmenjeniRacun = new AddUpdateRacunKupcaModel();
        this.dataSourceO = new MatTableDataSource<OtpremnicaZaKupcaModel>();
        this.dataSourceS = new MatTableDataSource<StavkaRacunaKupcaModel>();
        this.dataSourceNacinPlacanja = new MatTableDataSource<NacinPlacanjaModel>();

        this.ngOnInit();
        this.ngAfterViewInit();
      }, error => {this.toastr.error("Racun nije zapamcen")});
    }
  }

  public izbrisiRacun() {
    if(this.izmenjeniRacun.racunKupcaID === null) this.toastr.info("Izaberite racun");
    else {
      localStorage.removeItem(FORMAP);
      localStorage.removeItem(FORMA);
      localStorage.removeItem(RACUN);
      localStorage.removeItem(PROIZVOD);
      localStorage.removeItem(STAVKE);

      this.racunKupcaService.deleteRacunKupca(this.izmenjeniRacun.racunKupcaID).
      subscribe(data => {this.toastr.success("Racun je uspesno obrisan")});

      this.dataSourceR = new MatTableDataSource<RacunKupcaModel>();
      this.racun = new RacunKupcaModel();
      this.izmenjeniRacun = new AddUpdateRacunKupcaModel();
      this.dataSourceO = new MatTableDataSource<OtpremnicaZaKupcaModel>();
      this.dataSourceS = new MatTableDataSource<StavkaRacunaKupcaModel>();

      this.ngOnInit();
      this.ngAfterViewInit();
    }
  }
}
