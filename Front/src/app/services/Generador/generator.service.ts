import {inject, Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Generador} from "../../models/Generador";
import {Bolsa} from "../../models/Bolsa";

@Injectable({
  providedIn: 'root'
})
export class GeneratorService {
  private apiUrl = 'http://localhost:8080/Generator';
  private readonly http = inject(HttpClient);
  constructor() {}

  registerClient(generador: Generador): Observable<Generador> {

    //return this.http.post<Generador>('http://localhost:8080/Generator', generador);
    return this.http.post<Generador>('/Generator', generador);
  }

  realizarCompra(data: { title: string, unitPrice: number, quantity: number }): Observable<any> {
    const params = new HttpParams()
      .set('title', data.title)
      .set('unitPrice', data.unitPrice.toString())
      .set('quantity', data.quantity.toString());

    return this.http.post<any>('http://localhost:8080/Sale/crear-preferencia', null, { params });
  }
  getBolsas(): Observable<Bolsa[]> {
    return this.http.get<Bolsa[]>('http://localhost:8080/Bag');
  }
}
