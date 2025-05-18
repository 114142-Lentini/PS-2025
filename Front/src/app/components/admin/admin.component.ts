import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {MatTable, MatTableModule} from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import {MatList, MatListItem, MatListModule, MatNavList} from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatCard, MatCardModule, MatCardTitle} from "@angular/material/card";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import {MatDialog, MatDialogActions, MatDialogContent, MatDialogModule} from "@angular/material/dialog";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatNativeDateModule, MatOption} from "@angular/material/core";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {CommonModule} from "@angular/common";
import {MatSelect} from "@angular/material/select";
import {GeneratorService} from "../../services/Generador/generator.service";
import {Generador} from "../../models/Generador";
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
    MatNativeDateModule, MatTable, MatListItem, MatList, MatNavList, MatSidenavContainer, MatSidenav, MatSidenavContent, CommonModule, MatSelect, MatOption],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  @ViewChild('dialogTemplate') dialogTemplate!: TemplateRef<any>;
  rutaForm: FormGroup;
  generatorService = inject(GeneratorService)

  vehiculos = ['Camión 1', 'Camión 2', 'Camioneta 3'];
  zonas = ['Zona Norte', 'Zona Sur', 'Zona Este'];
  operarios = ['Juan Pérez', 'Ana López', 'Carlos Gómez'];
  solicitudes : Generador[] = [];
  generadores: Generador[] = [];

  constructor(private dialog: MatDialog, private fb: FormBuilder) {
    this.rutaForm = this.fb.group({
      vehiculo: ['', Validators.required],
      zona: ['', Validators.required],
      operario: ['', Validators.required],
      horaSalida: ['', Validators.required],
    });
  }
  ngOnInit(): void {
    this.cargarGeneradoresActivos();
    this.cargarGeneradoresPendientes()
  }

  cargarGeneradoresActivos(): void {
    this.generatorService.getGeneradoresActivos().subscribe({
      next: (data) => {
        this.generadores = data;
      },
      error: (err) => {
        console.error('Error al cargar generadores activos', err);
      }
    });
  }
  cargarGeneradoresPendientes(): void {
    this.generatorService.getGeneradoresPendientes().subscribe({
      next: (data) => {
        this.solicitudes = data;
        console.log(data)
      },
      error: (err) => {
        console.error('Error al cargar generadores pendientes', err);
      }
    });
  }
  abrirModal(): void {
    if (this.dialog.openDialogs.length === 0) {
      this.dialog.open(this.dialogTemplate);
    }
  }

  crearRuta(): void {
    if (this.rutaForm.valid) {
      console.log(this.rutaForm.value);
      this.dialog.closeAll(); // o puedes usar dialogRef.close()
    }
  }
}
