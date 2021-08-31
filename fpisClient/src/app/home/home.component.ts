import { Component, OnInit } from '@angular/core';

const HOME = 'podaci';
const ADDPOTVRDA = 'potvrda-add';
const UPDATEPOTVRDA = 'potvrda-update';
const ADDRACUN = 'racun-add';
const RACUNP = 'add';
const UPDATERACUN = 'racun-update';
const STAVKE = 'stavke';
const RACUNU = 'update';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    localStorage.removeItem(HOME);
    localStorage.removeItem(ADDPOTVRDA);
    localStorage.removeItem(UPDATEPOTVRDA);
    localStorage.removeItem(ADDRACUN);
    localStorage.removeItem(UPDATERACUN);
    localStorage.removeItem(RACUNP);
    localStorage.removeItem(STAVKE);
    localStorage.removeItem(RACUNU);
  }

}
