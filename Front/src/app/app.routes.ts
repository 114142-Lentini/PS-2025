import { Routes } from '@angular/router';
import {AltaGeneradorComponent} from "./components/alta-generador/alta-generador.component";
import {VentaComponent} from "./components/venta/venta.component";

export const routes: Routes = [
  { path: 'alta', component: AltaGeneradorComponent },
  {path: 'venta', component: VentaComponent },
];

