import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ClienteServiceService {

  private readonly http = inject(HttpClient);


  logout() {

  }
}
