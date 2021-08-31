
import {PotvrdaService} from '../core/service/potvrda.service';
import {ToastrService} from 'ngx-toastr';
import {MatTableDataSource} from '@angular/material/table';
import {ZahtevModel} from '../core/model/zahtevZaProveromKvaliteta.model';
import {PotvrdaOKvalitetuListModel} from '../core/model/potvrdaOKvalitetuList.model';
import {Component, OnInit} from '@angular/core';
import {AddUpdatePotvrdaOKvalitetuModel} from '../core/model/AddUpdatePotvrdaOKvalitetu.model';


const FORMA = 'potvrda-add';
const POTVRDA = 'podaci';

@Component({
  selector: 'app-potvrda',
  templateUrl: './potvrda-add.component.html',
  styleUrls: ['./potvrda-add.component.css']
})
export class PotvrdaAddComponent implements OnInit {

  listaPotvrda : PotvrdaOKvalitetuListModel = new PotvrdaOKvalitetuListModel();
  novaPotvrda: AddUpdatePotvrdaOKvalitetuModel = new AddUpdatePotvrdaOKvalitetuModel();
  zahtev : ZahtevModel = new ZahtevModel();

  idPotvrde : number = null;

  displayedColumns: string[] = [
    'zahtevID',
    'proizvodIDZaProveru',
    'datum',
    'napomena',
    'zahtevKreirao',
    'veterinarIDPrimio'
  ];
  dataSource : MatTableDataSource<ZahtevModel> = new MatTableDataSource<ZahtevModel>();

  constructor(private potvrdaService: PotvrdaService, private toastr: ToastrService) {  }

  ngOnInit(): void {
    this.getPotvrde();
    this.prikazZahteva();
  }


  getPotvrde(){

    this.potvrdaService.getAllPotvrde().subscribe(
      data => {
        this.listaPotvrda = data;

        var max = 0;
        for(var i = 0; i < this.listaPotvrda.potvrde.length; i++)
        {
          if(this.listaPotvrda.potvrde[i].potvrdaOKvalitetuID > max){
            max = this.listaPotvrda.potvrde[i].potvrdaOKvalitetuID;
          }
        }
        this.idPotvrde = max+1;
        if(JSON.parse(localStorage.getItem(POTVRDA)) !== null){
          this.novaPotvrda = JSON.parse(localStorage.getItem(POTVRDA));
        }
      },
      error => {
        this.toastr.error("Failed to get potvrde");
      }
    );

  }

  prikazZahteva(){
    if(JSON.parse(localStorage.getItem(FORMA)) !== null){
      this.zahtev = JSON.parse(localStorage.getItem(FORMA));
      this.dataSource.data = [this.zahtev];
    }
  }

  formaZahteva() {
    localStorage.removeItem(POTVRDA);
    localStorage.setItem(POTVRDA, JSON.stringify(this.novaPotvrda));

    localStorage.removeItem(FORMA);
    localStorage.setItem('formaZahteva', JSON.stringify(FORMA));
  }

  unesiPotvrdu() {
    this.novaPotvrda.potvrdaOKvalitetuID = this.idPotvrde;
    this.novaPotvrda.zahtevID = this.zahtev.zahtevID;
    this.novaPotvrda.proizvodID = this.zahtev.proizvod.proizvodID;
    this.novaPotvrda.veterinarID = this.zahtev.veterinar.veterinarID;

    if(this.novaPotvrda.opisPotvrde !== null && this.novaPotvrda.vrstaRobe !== null &&
      this.novaPotvrda.mestoIzdavanja !== null && this.novaPotvrda.datumPotvrde !== null){

      localStorage.removeItem(POTVRDA);
      localStorage.removeItem(FORMA);

      this.potvrdaService.addPotvrda(this.novaPotvrda).subscribe( data =>
      {this.toastr.success("Potvrda je uspesno zapamcena")});
      this.idPotvrde = this.novaPotvrda.potvrdaOKvalitetuID+1;
      this.novaPotvrda = new AddUpdatePotvrdaOKvalitetuModel();
      this.dataSource = new MatTableDataSource<ZahtevModel>();

    }else{
        this.toastr.error("Unesite sve podatke");
      }
    }

  odustaniOdPotvrde() {
    localStorage.removeItem(POTVRDA);
    localStorage.removeItem(FORMA);
  }
}
