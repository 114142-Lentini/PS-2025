import { Component } from '@angular/core';
import {MatCard, MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-pago-exitoso',
  standalone: true,
  imports: [
    MatCardModule,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './pago-exitoso.component.html',
  styleUrl: './pago-exitoso.component.css'
})
export class PagoExitosoComponent {

}
