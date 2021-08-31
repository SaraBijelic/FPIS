import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OtpremnicaService {

  constructor(private http: HttpClient) { }

  public getAllOtpremnica(): Observable<any> {
    return this.http.get(environment.url + "api/otpremnicaZaKupca");
  }

  public getOneOtpremnica(id : number): Observable<any>{
    return this.http.get(environment.url + "api/otpremnicaZaKupca/id/" + id);
  }

  public getAllDatum(datum : Date): Observable<any>{
    return this.http.get(environment.url + "api/otpremnicaZaKupca/" + datum);
  }
}
