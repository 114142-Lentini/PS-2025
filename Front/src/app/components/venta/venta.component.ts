import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Bolsa} from "../../models/Bolsa";
import {GeneratorService} from "../../services/Generador/generator.service";
import {CommonModule, CurrencyPipe} from "@angular/common";

@Component({
  selector: 'app-venta',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CurrencyPipe,
    CommonModule
  ],
  templateUrl: './venta.component.html',
  styleUrl: './venta.component.css'
})
export class VentaComponent {
  formulario!: FormGroup;
  generatorService : GeneratorService = inject(GeneratorService)
  constructor(private fb: FormBuilder ) {
    this.formulario = this.fb.group({
      idBolsa: [0], // valor inicial como índice (número)
      cantidad: [1, [Validators.required, Validators.min(1)]],
      nombre: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      contacto: ['', Validators.required]
    });
  }

  bolsas: any[] = [];
  precioUnitario: number = 0;
  totalCompra: number = 0;
  ngOnInit(): void {
    this.cargarBolsas(); // tu método para cargar las bolsas

    this.formulario = this.fb.group({
      idBolsa: ['', Validators.required],
      cantidad: [1, [Validators.required, Validators.min(1)]]
    });

    // Escuchar cambios del formulario
    this.formulario.valueChanges.subscribe(() => {
      this.actualizarPrecio();
    });
  }


  cargarBolsas(): void {
    this.generatorService.getBolsas().subscribe({
      next: (data) => {
        this.bolsas = data;
        console.log(data)
      },
      error: (err) => {
        console.error('Error al cargar bolsas', err);
      }
    });
  }
  actualizarPrecio(): void {
    const form = this.formulario.value;
    const bolsaSeleccionada = this.bolsas[form.idBolsa]; // usar índice
    this.precioUnitario = bolsaSeleccionada?.price || 0;
    this.totalCompra = this.precioUnitario * (form.cantidad || 0);
  }

  procesarCompra() {
    const form = this.formulario.value;
    const bolsaSeleccionada = this.bolsas[form.idBolsa]; // usar índice
    console.log(bolsaSeleccionada);
    if (!bolsaSeleccionada) {
      alert('Seleccione una bolsa válida');
      return;
    }

    const title = 'Bolsas'; // o como se llame
    const unitPrice = this.precioUnitario;
    const quantity = form.cantidad;

    this.generatorService.realizarCompra({ title, unitPrice, quantity }).subscribe({
      next: (preference) => {
        window.location.href = preference.sandboxInitPoint; // Redirige al checkout
      },
      error: (err) => {
        console.error(err);
        alert('Error al generar la preferencia de pago');
      }
    });
  }

}
