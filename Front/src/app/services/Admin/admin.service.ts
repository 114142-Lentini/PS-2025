import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Generador} from "../../models/Generador";
import {Zona} from "../../models/Zona";
import {Vehiculo} from "../../models/Vehiculo";
import {Empleado} from "../../models/Empleado";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl = 'http://localhost:8080/admin';

  private readonly http = inject(HttpClient);
  getZonas(): Observable<Zona[]> {
    return this.http.get<Zona[]>('http://localhost:8080/admin/zones');
  }
  getVehiculos(): Observable<Vehiculo[]> {
    return this.http.get<Vehiculo[]>('http://localhost:8080/admin/vehicles');
  }
  getEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>('http://localhost:8080/admin/employees');
  }
  getPedidosPorZona(zona: string): Observable<any[]> {
    const url = `${this.baseUrl}/pedidos?zone=${encodeURIComponent(zona)}`;
    return this.http.get<any[]>(url);
  }
}
