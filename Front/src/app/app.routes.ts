import { Routes } from '@angular/router';
import {AltaGeneradorComponent} from "./components/alta-generador/alta-generador.component";
import {VentaComponent} from "./components/venta/venta.component";
import {PagoExitosoComponent} from "./components/pago-exitoso/pago-exitoso.component";
import {PagoPendienteComponent} from "./components/pago-pendiente/pago-pendiente.component";
import {PagoFallidoComponent} from "./components/pago-fallido/pago-fallido.component";
import {HomeComponent} from "./components/home/home.component";
import {ClienteDashboardComponent} from "./components/cliente-dashboard/cliente-dashboard.component";
import {AdminComponent} from "./components/admin/admin.component";
import {LoginComponent} from "./components/login/login.component";
import {roleGuard} from "./guards/role.guard";
import {UnauthorizedComponent} from "./components/unauthorized/unauthorized.component";

export const routes: Routes = [
  { path: 'alta', component: AltaGeneradorComponent },
  { path: 'venta', component: VentaComponent },
  { path: '', component: HomeComponent },
  { path: 'pago-exitoso', component: PagoExitosoComponent },
  { path: 'pago-pendiente', component: PagoPendienteComponent },
  { path: 'pago-fallido', component: PagoFallidoComponent },
  { path: 'unauthorized', component: UnauthorizedComponent },

  {
    path: 'dashboard',
    component: ClienteDashboardComponent,
    canActivate: [roleGuard],
    data: { roles: ['ROLE_CLIENTE', 'ROLE_ADMIN']  }
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [roleGuard],
    data: { roles: ['ROLE_ADMIN'] }
  },

  { path: 'login', component: LoginComponent }
];

