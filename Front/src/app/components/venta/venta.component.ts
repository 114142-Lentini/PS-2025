import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Bolsa} from "../../models/Bolsa";
import {GeneratorService} from "../../services/services/generator.service";
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
    const data = {
      ...this.formulario.value,
      total: this.totalCompra
    };
    this.generatorService.realizarCompra(data).subscribe(res => {
      alert('Compra realizada con éxito');
    });
  }

}
