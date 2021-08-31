import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AddUpdateStavkeRacunaListaModel} from '../model/AddUpdateStavkeRacunaLista.model';

@Injectable({
  providedIn: 'root'
})
export class StavkeRacunaService {

  constructor(private http: HttpClient) { }

  public addStavkeRacuna(data: AddUpdateStavkeRacunaListaModel): Observable<any> {
    return this.http.post(environment.url + "api/stavkeRacunKupca", data);
  }

  public getStavkeRacunaIDRacuna(id : number): Observable<any>{
    return this.http.get(environment.url + "api/stavkeRacunKupca/id/" + id);
  }

  public getAllStavkeRacuna(): Observable<any> {
    return this.http.get(environment.url + "api/stavkeRacunKupca");
  }
}
