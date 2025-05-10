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
import {RetiroService} from "../../services/Retiro/retiro.service";

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
  retiroService = inject(RetiroService)
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
  confirmarRetiro(): void {
    if (this.retiroForm.valid) {
      const cantidad = this.retiroForm.value.cantidad;
      const fecha: Date = this.retiroForm.value.fecha;
      const hora: string = this.retiroForm.value.horario;

      const collectDate = new Date(fecha);
      collectDate.setHours(0, 0, 0, 0); // aseguramos que solo tenga la fecha

      const dto = {
        countBags: cantidad,
        collectDate: collectDate.toISOString(),        // LocalDateTime
        collectHour: `${hora}:00`                      // LocalTime con segundos
      };

      this.retiroService.solicitarRetiro(dto).subscribe({
        next: () => {
          alert('Retiro solicitado con éxito');
          this.retiroForm.reset();
          this.dialog.closeAll();
        },
        error: () => {
          alert('Error al solicitar el retiro');
        }
      });
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
