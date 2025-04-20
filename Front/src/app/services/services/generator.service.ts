import {inject, Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
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

  realizarCompra(data: any): Observable<Bolsa> {
    return this.http.post<Bolsa>(`/Generador/${data.id}`, data);
  }
}
