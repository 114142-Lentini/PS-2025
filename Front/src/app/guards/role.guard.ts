import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {JwtHelperService} from "@auth0/angular-jwt";

export const roleGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const jwtHelper = new JwtHelperService();

  const token = localStorage.getItem('token');
  if (!token || jwtHelper.isTokenExpired(token)) {
    router.navigate(['/login']);
    return false;
  }

  const decodedToken = jwtHelper.decodeToken(token);
  const expectedRoles = route.data['roles'] as string[];
  const userRoles = decodedToken.roles || [];

  const hasRole = expectedRoles.some(role => userRoles.includes(role));
  if (!hasRole) {
    router.navigate(['/unauthorized']); // o cualquier ruta de error
    return false;
  }

  return true;
};
