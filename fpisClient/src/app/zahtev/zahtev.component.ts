import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ZahtevModel} from '../core/model/zahtevZaProveromKvaliteta.model';
import {ZahtevService} from '../core/service/zahtev.service';
import {ToastrService} from 'ngx-toastr';
import {ZahtevZaProveromKvalitetaListModel} from '../core/model/ZahtevZaProveromKvalitetaList.model';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-zahtev',
  templateUrl: './zahtev.component.html',
  styleUrls: ['./zahtev.component.css']
})
export class ZahtevComponent implements OnInit, AfterViewInit {

  listaZahteva : ZahtevZaProveromKvalitetaListModel = new ZahtevZaProveromKvalitetaListModel();
  zahtev: ZahtevModel = new ZahtevModel();

  idFilter = new FormControl('');
  datumFilter = new FormControl('');

  forma : string = '';

  displayedColumnsZahtev: string[] = [
    'zahtevID',
    'proizvodZaProveru',
    'datum',
    'napomena',
    'zahtevKreirao',
    'veterinarPrimio'
  ];

  filterValues = {
    zahtevID: '',
    datum: ''
  };

  dataSource : MatTableDataSource<ZahtevModel> = new MatTableDataSource<ZahtevModel>();
  clickedRow : ZahtevModel = new ZahtevModel();
  clickedRows : Set<ZahtevModel> = new Set<ZahtevModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private zahtevService : ZahtevService, private toastr: ToastrService) {}

  ngOnInit(): void {
    this.getZahtevi();
    this.applyFilter();
    this.forma = JSON.parse(localStorage.getItem('formaZahteva'));
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  onClick(parametar : ZahtevModel){
    this.clickedRow = parametar;
    this.clickedRows = new Set<ZahtevModel>();
    this.clickedRows[0] = parametar;
  }

  getZahtevi() {

    this.zahtevService.getAllZahtevi().subscribe(
      data => {
        this.listaZahteva = data;
        this.dataSource.data = this.listaZahteva.zahtevi;
        this.dataSource.filterPredicate = this.createFilter();
      },
      error => {
        this.toastr.error("Failed to get zahtevi");
      }
    );
  }

  applyFilter() {
    this.dataSource.filterPredicate = this.createFilter();
    this.idFilter.valueChanges
      .subscribe(
        zahtevID => {
          this.filterValues.zahtevID = zahtevID;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
    this.datumFilter.valueChanges
      .subscribe(
        datum => {
          this.filterValues.datum = datum;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
  }

  createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.zahtevID.toString().toLowerCase().indexOf(searchTerms.zahtevID) !== -1
        && data.datum.toString().toLowerCase().indexOf(searchTerms.datum) !== -1
    }
    return filterFunction;
  }

  saveZahtevInStorage(data : ZahtevModel){
    if(data === null){
      return;
    }
      try {
        localStorage.removeItem(this.forma);
        localStorage.setItem(this.forma, JSON.stringify(data));
      } catch (e) {
        console.error('Error saving to localStorage', e);
      }
  }

}
