import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {PotvrdaModel} from '../model/potvrdaOKvalitetu.model';

@Injectable({
  providedIn: 'root'
})
export class FirmaService {

  constructor(private hhtp: HttpClient) { }
  addFirma(data: PotvrdaModel): Observable<any> {
    return this.hhtp.post(environment.url + 'api/potvrda-add', data);
  }
}
