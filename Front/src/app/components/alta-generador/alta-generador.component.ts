import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {GeneratorService} from "../../services/Generador/generator.service";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-alta-generador',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './alta-generador.component.html',
  styleUrl: './alta-generador.component.css'
})
export class AltaGeneradorComponent {
  formulario!: FormGroup;
  generatorService : GeneratorService = inject(GeneratorService)
  constructor(private fb: FormBuilder ) {
    this.formulario = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required],
      contact: ['', Validators.required],
      type: ['publico', Validators.required]
    });
  }

  ngOnInit(): void {

  }

  registrar() {
    const generador = {
      ...this.formulario.value
    }
    this.generatorService.registerClient(generador).subscribe({
      next: (response) => {
        console.log('Respuesta de la API:', response);
        alert('Registro exitoso');
        this.formulario.reset(); // 🔹 Limpiar los campos
      },
      error: (err) => {
        console.error('Error al registrar:', err);
        alert('Ocurrió un error al registrar');
      }
    });
  }
}
