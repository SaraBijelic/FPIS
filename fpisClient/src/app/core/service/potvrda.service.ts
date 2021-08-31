import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {PotvrdaModel} from '../model/potvrdaOKvalitetu.model';
import {AddUpdatePotvrdaOKvalitetuModel} from '../model/AddUpdatePotvrdaOKvalitetu.model';


@Injectable({
  providedIn: 'root'
})
export class PotvrdaService{

  constructor(private http: HttpClient) { }

  public addPotvrda(data: AddUpdatePotvrdaOKvalitetuModel): Observable<any> {
    return this.http.post(environment.url + "api/potvrda", data);
  }

  public updatePotvrda(data: AddUpdatePotvrdaOKvalitetuModel): Observable<any> {
    return this.http.put(environment.url + "api/potvrda", data);
  }

  public getAllPotvrde(): Observable<any>  {
    return this.http.get(environment.url + "api/potvrda");
  }

  public deletePotvrda(id : number): Observable<any> {
    return this.http.delete(environment.url + "api/potvrda/"+ id);
  }

}
