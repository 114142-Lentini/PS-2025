import { Component } from '@angular/core';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-pago-fallido',
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatCardContent,
    MatCardActions,MatCardModule,
    MatButtonModule
  ],
  templateUrl: './pago-fallido.component.html',
  styleUrl: './pago-fallido.component.css'
})
export class PagoFallidoComponent {

}
