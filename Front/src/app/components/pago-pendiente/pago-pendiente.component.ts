import { Component } from '@angular/core';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardModule} from "@angular/material/card";
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-pago-pendiente',
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatCardContent,
    MatCardActions,MatCardModule,
    MatButtonModule
  ],
  templateUrl: './pago-pendiente.component.html',
  styleUrl: './pago-pendiente.component.css'
})
export class PagoPendienteComponent {

}
