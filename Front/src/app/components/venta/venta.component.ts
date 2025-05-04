import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Bolsa} from "../../models/Bolsa";
import {GeneratorService} from "../../services/Generador/generator.service";
import {CurrencyPipe} from "@angular/common";

@Component({
  selector: 'app-venta',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CurrencyPipe
  ],
  templateUrl: './venta.component.html',
  styleUrl: './venta.component.css'
})
export class VentaComponent {
  formulario!: FormGroup;
  generatorService : GeneratorService = inject(GeneratorService)
  constructor(private fb: FormBuilder ) {
    this.formulario = this.fb.group({
      idBolsa: [null, Validators.required],
      cantidad: [1, [Validators.required, Validators.min(1)]],
      nombre: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      contacto: ['', Validators.required]
    });
  }

  bolsas: Bolsa[] = []; // cargadas desde backend
  precioUnitario = 0;
  totalCompra = 0;

  actualizarPrecio() {
    const idBolsa = this.formulario.value.idBolsa;
    // Obtener precio de bolsa seleccionada (llamada al backend)
    this.actualizarTotal();
  }

  actualizarTotal() {
    const cantidad = this.formulario.value.cantidad;
    this.totalCompra = cantidad * this.precioUnitario;
  }

  procesarCompra() {
    const form = this.formulario.value;
    const bolsaSeleccionada = this.bolsas.find(b => b.id === form.idBolsa);

    if (!bolsaSeleccionada) {
      alert('Seleccione una bolsa válida');
      return;
    }

    const title = 'Bolsas y Precintos'; // o como se llame
    const unitPrice = this.precioUnitario;
    const quantity = form.cantidad;

    this.generatorService.realizarCompra({ title, unitPrice, quantity }).subscribe({
      next: (preference) => {
        window.location.href = preference.init_point; // Redirige al checkout
      },
      error: (err) => {
        console.error(err);
        alert('Error al generar la preferencia de pago');
      }
    });
  }

}
