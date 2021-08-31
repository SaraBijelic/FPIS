import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {OtpremnicaZaKupcaModel} from '../core/model/otpremnicaZaKupca.model';
import {OtpremnicaService} from '../core/service/otpremnica.service';
import {ToastrService} from 'ngx-toastr';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {OtpremnicaListModel} from '../core/model/otpremnicaList.model';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-otpremnica',
  templateUrl: './otpremnica.component.html',
  styleUrls: ['./otpremnica.component.css']
})
export class OtpremnicaComponent implements OnInit, AfterViewInit {

  otpremnica: OtpremnicaZaKupcaModel = new OtpremnicaZaKupcaModel();
  listaOtpremnica : OtpremnicaListModel = new OtpremnicaListModel();

  idFilter = new FormControl('');
  datumFilter = new FormControl('');

  forma : string = '';

  displayedColumnsOtpremnica: string[] = [
    'otpremnicaZaKupcaID',
    'otpremnicuPrimio',
    'datumOtpremanja',
    'radnikDoprema',
    'kupacOtp',
    'radnikKreirao'
  ];

  filterValues = {
    otpremnicaZaKupcaID: '',
    datumOtpremanja: ''
  };

  dataSource : MatTableDataSource<OtpremnicaZaKupcaModel> = new MatTableDataSource<OtpremnicaZaKupcaModel>();
  clickedRow : OtpremnicaZaKupcaModel = new OtpremnicaZaKupcaModel();
  clickedRows : Set<OtpremnicaZaKupcaModel> = new Set<OtpremnicaZaKupcaModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private otpremnicaService : OtpremnicaService, private toastr : ToastrService) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  onClick(parametar : OtpremnicaZaKupcaModel){
    this.clickedRow = parametar;
    this.clickedRows = new Set<OtpremnicaZaKupcaModel>();
    this.clickedRows[0] = parametar;
  }

  getOtpremnice() {

    this.otpremnicaService.getAllOtpremnica().subscribe(
      data => {
        this.listaOtpremnica = data;
        this.dataSource.data = this.listaOtpremnica.otpremnice;
        this.dataSource.filterPredicate = this.createFilter();
      },
      error => {
        this.toastr.error("Failed to get otpremnice");
      }
    );
  }

  ngOnInit(): void {
    this.getOtpremnice()
    this.applyFilter();
    this.forma = JSON.parse(localStorage.getItem('formaOtpremnice'));
  }

  applyFilter() {
    this.dataSource.filterPredicate = this.createFilter();
    this.idFilter.valueChanges
      .subscribe(
        otpremnicaZaKupcaID => {
          this.filterValues.otpremnicaZaKupcaID = otpremnicaZaKupcaID;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
    this.datumFilter.valueChanges
      .subscribe(
        datumOtpremanja => {
          this.filterValues.datumOtpremanja = datumOtpremanja;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
  }

  createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.otpremnicaZaKupcaID.toString().toLowerCase().indexOf(searchTerms.otpremnicaZaKupcaID) !== -1
        && data.datumOtpremanja.toString().toLowerCase().indexOf(searchTerms.datumOtpremanja) !== -1
    }
    return filterFunction;
  }

  saveOtpremnicaInStorage(data : OtpremnicaZaKupcaModel){
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

