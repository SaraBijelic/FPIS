import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AddUpdatePotvrdaOKvalitetuModel} from '../model/AddUpdatePotvrdaOKvalitetu.model';
import {AddUpdateRacunKupcaModel} from '../model/AddUpdateRacunKupca.model';

@Injectable({
  providedIn: 'root'
})
export class RacunKupcaService {

  constructor(private http: HttpClient) { }

  public getAllRacuni(): Observable<any> {
    return this.http.get(environment.url + "api/racunKupca");
  }

  public addRacun(data: AddUpdateRacunKupcaModel): Observable<any> {
    return this.http.post(environment.url + "api/racunKupca", data);
  }

  public deleteRacunKupca(id : number): Observable<any> {
    return this.http.delete(environment.url + "api/racunKupca/"+ id);
  }

  public updateRacunKupca(data: AddUpdateRacunKupcaModel): Observable<any> {
    return this.http.put(environment.url + "api/racunKupca", data);
  }
}
