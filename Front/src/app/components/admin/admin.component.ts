import { Component } from '@angular/core';
import {MatTable, MatTableModule} from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import {MatList, MatListItem, MatListModule, MatNavList} from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatCard, MatCardModule, MatCardTitle} from "@angular/material/card";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import {MatDialogActions, MatDialogContent, MatDialogModule} from "@angular/material/dialog";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatNativeDateModule} from "@angular/material/core";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {CommonModule} from "@angular/common";
@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [MatToolbar,
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
    MatNativeDateModule, MatTable, MatListItem, MatList, MatNavList, MatSidenavContainer, MatSidenav, MatSidenavContent, CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  // Datos simulados para solicitudes de registro
  registrationRequests = [
    { nombre: 'Juan Pérez', email: 'juan@gmail.com', fecha: '2025-05-01' },
    { nombre: 'María López', email: 'maria@gmail.com', fecha: '2025-05-03' }
  ];

  // Lista de generadores activos simulados
  generadoresActivos = [
    { nombre: 'Generador A', tipo: 'Industrial' },
    { nombre: 'Generador B', tipo: 'Domiciliario' },
    { nombre: 'Generador C', tipo: 'Institucional' }
  ];

  // Acciones para solicitudes
  aprobarSolicitud(request: any) {
    console.log('Solicitud aprobada:', request);
    this.registrationRequests = this.registrationRequests.filter(r => r !== request);
  }

  rechazarSolicitud(request: any) {
    console.log('Solicitud rechazada:', request);
    this.registrationRequests = this.registrationRequests.filter(r => r !== request);
  }

  // Acciones para hojas de ruta
  gestionarHojas() {
    console.log('Administrar hojas de ruta...');
    // Aquí podrías redirigir a otra pantalla o abrir un diálogo
  }
  opcionSeleccionada = 'solicitudes';

  seleccionarOpcion(opcion: string) {
    this.opcionSeleccionada = opcion;
  }
}
