import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {ProizvodModel} from '../core/model/proizvod.model';
import {ProizvodService} from '../core/service/proizvod.service';
import {ToastrService} from 'ngx-toastr';
import {ProizvodListModel} from '../core/model/proizvodList.model';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-proizvod',
  templateUrl: './proizvod.component.html',
  styleUrls: ['./proizvod.component.css']
})
export class ProizvodComponent implements OnInit, AfterViewInit {

  listaProizvoda : ProizvodListModel = new ProizvodListModel();
  proizvod: ProizvodModel = new ProizvodModel();

  idFilter = new FormControl('');
  nazivFilter = new FormControl('');

  forma : string = '';

  displayedColumnsProizvod: string[] = [
    'proizvodID',
    'nazivProizvoda',
    'datum',
    'cena',
    'vrstaProizvoda',
    'trenutnoStanjeZaliha',
    'jedinicaMere'
  ];

  filterValues = {
    proizvodID: '',
    nazivProizvoda: ''
  };

  dataSource : MatTableDataSource<ProizvodModel> = new MatTableDataSource<ProizvodModel>();
  clickedRow : ProizvodModel = new ProizvodModel();
  clickedRows : Set<ProizvodModel> = new Set<ProizvodModel>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private proizvodService : ProizvodService, private toastr: ToastrService) {}

  onClick(parametar : ProizvodModel){
    this.clickedRow = parametar;
    this.clickedRows = new Set<ProizvodModel>();
    this.clickedRows[0] = parametar;
  }

  ngOnInit(): void {
    this.getProizvodi();
    this.applyFilter();
    this.forma = JSON.parse(localStorage.getItem('formaProizvoda'));
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  getProizvodi() {

    this.proizvodService.getAllProizvod().subscribe(
      data => {
        this.listaProizvoda = data;
        this.dataSource.data = this.listaProizvoda.proizvodi;
        this.dataSource.filterPredicate = this.createFilter();
      },
      error => {
        this.toastr.error("Failed to get proizvodi");
      }
    );
  }

  applyFilter() {
    this.dataSource.filterPredicate = this.createFilter();
    this.idFilter.valueChanges
      .subscribe(
        proizvodID => {
          this.filterValues.proizvodID = proizvodID;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
    this.nazivFilter.valueChanges
      .subscribe(
        nazivProizvoda => {
          this.filterValues.nazivProizvoda = nazivProizvoda;
          this.dataSource.filter = JSON.stringify(this.filterValues);
        }
      )
  }

  createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.proizvodID.toString().toLowerCase().indexOf(searchTerms.proizvodID) !== -1
        && data.nazivProizvoda.toString().toLowerCase().indexOf(searchTerms.nazivProizvoda) !== -1
    }
    return filterFunction;
  }

  saveProizvodInStorage(data : ProizvodModel){
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
