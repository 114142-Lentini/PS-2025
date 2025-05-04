import {Component, inject, ViewChild} from '@angular/core';
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatCard, MatCardModule, MatCardTitle} from "@angular/material/card";
import {Router, RouterLink} from "@angular/router";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {ClienteServiceService} from "../../services/cliente-service.service";
import {MatDialog, MatDialogActions, MatDialogContent, MatDialogModule} from "@angular/material/dialog";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatNativeDateModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";

@Component({
  selector: 'app-cliente-dashboard',
  standalone: true,
  imports: [
    MatToolbar,
    MatCard,
    MatCardTitle,
    MatDivider,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatDividerModule,
    MatDialogContent,
    MatFormField,
    MatDatepickerToggle,
    MatDatepickerInput,
    MatDatepicker,
    MatDialogActions,
    ReactiveFormsModule,
    MatLabel,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  templateUrl: './cliente-dashboard.component.html',
  styleUrl: './cliente-dashboard.component.css'
})
export class ClienteDashboardComponent {
  nombreCliente = 'Juan Pérez';
  router = inject(Router)
  service = inject(ClienteServiceService)
  @ViewChild('retiroModal') retiroModalTemplate: any;
  retiroForm: FormGroup;
  constructor(
    private dialog: MatDialog,
    private fb: FormBuilder,
  ) {
    this.retiroForm = this.fb.group({
      cantidad: [''],
      fecha: [''],
      horario: [''],
    });
  }
  irAVenta() {
    this.router.navigate(['/venta']);
  }

  irASolicitud() {
    this.router.navigate(['/solicitud-retiro']);
  }
  confirmarRetiro() {
    if (this.retiroForm.valid) {
      const datos = this.retiroForm.value;
      console.log('Datos del retiro:', datos);
      this.dialog.closeAll(); // Cierra el modal
    }
  }
  openModal() {
    this.dialog.open(this.retiroModalTemplate);
  }
  cerrarSesion() {
    // lógica de logout, por ejemplo:
    this.service.logout();
    this.router.navigate(['/login']);
  }

  protected readonly opener = opener;
}
