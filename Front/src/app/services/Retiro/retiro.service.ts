import {inject, Injectable} from '@angular/core';
import {roadmap} from "../../models/roadmap";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RetiroService {

  private apiUrl = 'http://localhost:8080/roadmap'; // Reemplaza con tu URL real

  private readonly http = inject(HttpClient);

  solicitarRetiro(dto: roadmap): Observable<roadmap> {
    return this.http.post<roadmap>(`${this.apiUrl}/crear`, dto);
  }
}
