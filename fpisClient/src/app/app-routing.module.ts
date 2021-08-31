import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {PotvrdaAddComponent} from './potvrda-add/potvrda-add.component';
import {HomeComponent} from './home/home.component';
import {PotvrdaUpdateComponent} from './potvrda-update/potvrda-update.component';
import {ZahtevComponent} from './zahtev/zahtev.component';
import {OtpremnicaComponent} from './otpremnica/otpremnica.component';
import {ProizvodComponent} from './proizvod/proizvod.component';
import {RacunAddComponent} from './racun-add/racun-add.component';
import {RacunUpdateComponent} from './racun-update/racun-update.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'potvrda-add',
    component: PotvrdaAddComponent,
  },
  {
    path: 'potvrda-update',
    component: PotvrdaUpdateComponent,
  },
  {
    path: 'zahtev',
    component: ZahtevComponent,
  },
  {
    path: 'otpremnica',
    component: OtpremnicaComponent,
  },
  {
    path: 'proizvod',
    component: ProizvodComponent,
  },
  {
    path: 'racun-add',
    component: RacunAddComponent,
  },
  {
    path: 'racun-update',
    component: RacunUpdateComponent,
  }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
