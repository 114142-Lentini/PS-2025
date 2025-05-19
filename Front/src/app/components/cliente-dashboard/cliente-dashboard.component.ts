import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
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
import {MatList, MatListItem} from "@angular/material/list";
import {DatePipe, NgForOf, NgIf} from "@angular/common";
import {GeneratorService} from "../../services/Generador/generator.service";
import {AdminService} from "../../services/Admin/admin.service";

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
    MatList,
    DatePipe,
    MatListItem,
    NgIf,
    NgForOf,
  ],
  templateUrl: './cliente-dashboard.component.html',
  styleUrl: './cliente-dashboard.component.css'
})
export class ClienteDashboardComponent {
  nombreCliente = 'Franco';
  router = inject(Router)
  service = inject(ClienteServiceService)
  retiroService = inject(RetiroService)
  generatorService = inject(GeneratorService)


  @ViewChild('retiroModal') retiroModalTemplate: any;
  @ViewChild('historialDialog') historialDialog!: TemplateRef<any>;

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
  historial: any;

  verHistorial(): void {
    this.generatorService.getHistorialCompras().subscribe({
      next: (data) => {
        this.historial = data;
        this.dialog.open(this.historialDialog);
      },
      error: (err) => {
        console.error('Error al cargar el historial de compras:', err);
      }
    });
  }
}
