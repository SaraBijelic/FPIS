
import {PotvrdaModel} from '../core/model/potvrdaOKvalitetu.model';
import {PotvrdaService} from '../core/service/potvrda.service';
import {ToastrService} from 'ngx-toastr';
import {PotvrdaOKvalitetuListModel} from '../core/model/potvrdaOKvalitetuList.model';
import {MatTableDataSource} from '@angular/material/table';
import {ZahtevModel} from '../core/model/zahtevZaProveromKvaliteta.model';
import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {FormControl} from '@angular/forms';
import {AddUpdatePotvrdaOKvalitetuModel} from '../core/model/AddUpdatePotvrdaOKvalitetu.model';

const FORMA = 'potvrda-update';
const POTVRDA = 'podaci';

@Component({
  selector: 'app-potvrda-update',
  templateUrl: './potvrda-update.component.html',
  styleUrls: ['./potvrda-update.component.css']
})
export class PotvrdaUpdateComponent implements OnInit, AfterViewInit {

  listaPotvrda : PotvrdaOKvalitetuListModel = new PotvrdaOKvalitetuListModel();
  potvrda : PotvrdaModel = new PotvrdaModel();
  izmenjenaPotvrda : AddUpdatePotvrdaOKvalitetuModel = new AddUpdatePotvrdaOKvalitetuModel();

  idFilter = new FormControl('');
  datumFilter = new FormControl('');

  displayedColumnsPotvdra: string[] = [
    'potvrdaID',
    'zahtevID',
    'datumPotvrde',
    'mestoIzdavanja',
    'vrstaRobe',
    'opis'
  ];

  displayedColumnsZahtev: string[] = [
    'zahtevID',
    'proizvodIDZaProveru',
    'datum',
    'napomena',
    'zahtevKreirao',
    'veterinarIDPrimio'
  ];

  filterValues = {
    potvrdaOKvalitetuID: '',
    datumPotvrde: ''
  };

  dataSource : MatTableDataSource<ZahtevModel> = new MatTableDataSource<ZahtevModel>();
  dataSourceP : MatTableDataSource<PotvrdaModel> = new MatTableDataSource<PotvrdaModel>();
  clickedRow : PotvrdaModel = new PotvrdaModel();
  clickedRows : Set<PotvrdaModel> = new Set<PotvrdaModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private potvrdaService: PotvrdaService, private toastr: ToastrService) {  }

  ngOnInit(): void {
    this.getPotvdre();
    this.applyFilter();
    this.prikazZahteva();
  }

  ngAfterViewInit(): void {
    this.dataSourceP.paginator = this.paginator;
    this.dataSourceP.sort = this.sort;
  }

  formaZahteva() {
    localStorage.removeItem(POTVRDA);
    localStorage.setItem(POTVRDA, JSON.stringify(this.izmenjenaPotvrda));

    localStorage.removeItem(FORMA);
    localStorage.setItem('formaZahteva', JSON.stringify(FORMA));
  }

  getPotvdre() {
    this.potvrdaService.getAllPotvrde().subscribe(
      data => {
        this.listaPotvrda = data;
        this.dataSourceP.data = this.listaPotvrda.potvrde;
        if(JSON.parse(localStorage.getItem(POTVRDA)) !== null){
          this.izmenjenaPotvrda = JSON.parse(localStorage.getItem(POTVRDA));
        }
      },error => {
        this.toastr.error("Failed to get potvrde");
      }
    );
  }

  prikazZahteva(){
    if(JSON.parse(localStorage.getItem(FORMA)) !== null){
      this.potvrda.zahtev = JSON.parse(localStorage.getItem(FORMA));
      this.dataSource.data = [this.potvrda.zahtev];
    }
  }

  onClick(parametar : PotvrdaModel){
    this.clickedRow = parametar;
    this.clickedRows = new Set<PotvrdaModel>();
    this.clickedRows[0] = parametar;
  }

  applyFilter() {
    this.dataSourceP.filterPredicate = this.createFilter();
    this.idFilter.valueChanges
      .subscribe(
        potvrdaOKvalitetuID => {
          this.filterValues.potvrdaOKvalitetuID = potvrdaOKvalitetuID;
          this.dataSourceP.filter = JSON.stringify(this.filterValues);
        }
      )
    this.datumFilter.valueChanges.subscribe(datumPotvrde => {
          this.filterValues.datumPotvrde = datumPotvrde;
          this.dataSourceP.filter = JSON.stringify(this.filterValues);
        }
      )
  }

  unesiPotvrdu() {

    if(this.izmenjenaPotvrda.zahtevID !== null && this.izmenjenaPotvrda.opisPotvrde !== null &&
      this.izmenjenaPotvrda.vrstaRobe !== null && this.izmenjenaPotvrda.mestoIzdavanja !== null &&
      this.izmenjenaPotvrda.datumPotvrde !== null){

      if(this.izmenjenaPotvrda.datumPotvrde === null) this.toastr.info("Unesite datum");
      else if(this.izmenjenaPotvrda.mestoIzdavanja === '') this.toastr.info("Unesite mesto izdavanja");
      else if(this.izmenjenaPotvrda.vrstaRobe === '') this.toastr.info("Unesite vrstu robe");
      else if(this.izmenjenaPotvrda.opisPotvrde === '') this.toastr.info("Unesite opis");
      else{

      this.izmenjenaPotvrda.zahtevID = this.dataSource.data[0].zahtevID;

      localStorage.removeItem(POTVRDA);
      localStorage.removeItem(FORMA);

      this.potvrdaService.updatePotvrda(this.izmenjenaPotvrda).
      subscribe(data => {this.toastr.success("Potvrda je uspesno zapamcena")});
      this.izmenjenaPotvrda = new AddUpdatePotvrdaOKvalitetuModel();
      this.getPotvdre();
      this.dataSource = new MatTableDataSource<ZahtevModel>();}

      this.ngOnInit();
      this.ngAfterViewInit();
    }else{
      this.toastr.info("Unesite podatke");
    }
  }

  izabranaPotvrda() {
    if(this.clickedRow == null) {
      return;
    }else{
      this.potvrda.zahtev = this.clickedRow.zahtev;
      this.dataSource.data = [this.potvrda.zahtev];
      this.izmenjenaPotvrda.zahtevID = this.potvrda.zahtev.zahtevID;
      this.izmenjenaPotvrda.potvrdaOKvalitetuID = this.clickedRow.potvrdaOKvalitetuID;
      this.izmenjenaPotvrda.datumPotvrde = this.clickedRow.datumPotvrde;
      this.izmenjenaPotvrda.mestoIzdavanja = this.clickedRow.mestoIzdavanja;
      this.izmenjenaPotvrda.vrstaRobe = this.clickedRow.vrstaRobe;
      this.izmenjenaPotvrda.opisPotvrde = this.clickedRow.opisPotvrde;
      this.izmenjenaPotvrda.veterinarID = this.potvrda.zahtev.veterinar.veterinarID;
      this.izmenjenaPotvrda.proizvodID = this.potvrda.zahtev.proizvod.proizvodID;
    }
  }

  createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.potvrdaOKvalitetuID.toString().toLowerCase().indexOf(searchTerms.potvrdaOKvalitetuID) !== -1
        && data.datumPotvrde.toString().toLowerCase().indexOf(searchTerms.datumPotvrde) !== -1
    }
    return filterFunction;
  }

  izbrisiPotvrdu() {
    if(this.izmenjenaPotvrda.potvrdaOKvalitetuID === null) this.toastr.info("Izaberite potvrdu");
    else {
      localStorage.removeItem(POTVRDA);
      localStorage.removeItem(FORMA);

      this.potvrdaService.deletePotvrda(this.izmenjenaPotvrda.potvrdaOKvalitetuID).
      subscribe(data => {this.toastr.success("Potvrda je uspesno obrisana")});
      this.dataSourceP = new MatTableDataSource<PotvrdaModel>();
      this.izmenjenaPotvrda = new AddUpdatePotvrdaOKvalitetuModel();
      this.dataSource = new MatTableDataSource<ZahtevModel>();

      this.ngOnInit();
      this.ngAfterViewInit();
    }
  }
}
