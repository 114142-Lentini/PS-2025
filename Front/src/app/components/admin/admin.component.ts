import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {MatTable, MatTableModule} from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import {MatList, MatListItem, MatListModule, MatListOption, MatNavList, MatSelectionList} from '@angular/material/list';
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
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatNativeDateModule, MatOption} from "@angular/material/core";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {CommonModule} from "@angular/common";
import {MatSelect} from "@angular/material/select";
import {GeneratorService} from "../../services/Generador/generator.service";
import {Generador} from "../../models/Generador";
import {AdminService} from "../../services/Admin/admin.service";
import {Vehiculo} from "../../models/Vehiculo";
import {Empleado} from "../../models/Empleado";
import {Zona} from "../../models/Zona";
import {Pedido} from "../../models/Pedido";
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
    MatNativeDateModule, MatTable, MatListItem, MatList, MatNavList, MatSidenavContainer, MatSidenav, MatSidenavContent, CommonModule, MatSelect, MatOption, MatSelectionList, FormsModule, MatListOption],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  @ViewChild('dialogTemplate') dialogTemplate!: TemplateRef<any>;
  rutaForm: FormGroup;
  generatorService = inject(GeneratorService)
  adminService = inject(AdminService)
  zonaSeleccionada: string = '';
  pedidos: Pedido[] = [];

  vehiculos : Vehiculo[] = [];
  zonas: Zona[] = [];
  operarios : Empleado[]= [];
  solicitudes : Generador[] = [];
  generadores: Generador[] = [];
  selectedPedidos: any[] = [];


  constructor(private dialog: MatDialog, private fb: FormBuilder) {
    this.rutaForm = this.fb.group({
      vehiculo: ['', Validators.required],
      zona: ['', Validators.required],
      operario: ['', Validators.required],
      horaSalida: ['', Validators.required],  // string tipo "14:30"
      pedidos: [[], Validators.required] // aseguramos al menos uno seleccionado
    });
  }

  onZonaSeleccionada(zona: string): void {
    this.zonaSeleccionada = zona;

    // ✅ Actualizar el valor en el form
    this.rutaForm.get('zona')?.setValue(zona);

    this.adminService.getPedidosPorZona(zona).subscribe({
      next: (data) => {
        console.log('Pedidos recibidos:', data);
        this.pedidos = data;
      },
      error: (err) => {
        console.error('Error al obtener los pedidos:', err);
      }
    });
  }
  ngOnInit(): void {
    this.cargarGeneradoresActivos();
    this.cargarGeneradoresPendientes()
    this.cargarModal()
  }
  cargarModal() : void {
    this.adminService.getZonas().subscribe({
      next: (data) => {
        this.zonas = data;
      },
      error: (err) => {
        console.error('Error al cargar las zonas', err);
      }
    })
    this.adminService.getEmpleados().subscribe({
      next: (data) => {
        this.operarios = data;
      },
      error: (err) => {
        console.error('Error al cargar los empleados', err);
      }
    })
    this.adminService.getVehiculos().subscribe({
      next: (data) => {
        this.vehiculos = data;
      },
      error: (err) => {
        console.error('Error al cargar los vehiculos', err);
      }
    })
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

  crearRuta() {
    if (this.rutaForm.invalid) return;

    const hojaRuta = {
      ...this.rutaForm.value,
      zona: this.zonaSeleccionada,
    };
    alert("exito")
    this.rutaForm.reset()
    console.log('Hoja de ruta a enviar:', hojaRuta);

  }

  aprobarSolicitud(solicitud: any): void {
    // Aquí puedes hacer una llamada al backend para aprobar la solicitud
    console.log('Solicitud aprobada:', solicitud);
    // Lógica para actualizar la lista o hacer reload
  }
}
