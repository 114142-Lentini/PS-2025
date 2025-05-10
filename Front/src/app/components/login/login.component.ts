import {Component, inject} from '@angular/core';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {CommonModule} from "@angular/common";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {JwtHelperService} from "@auth0/angular-jwt";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCard,
    ReactiveFormsModule,
    MatFormField, MatLabel, MatError, MatCardTitle, MatCardContent, MatCardActions, CommonModule, MatInput, MatButton, MatCardHeader
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm!: FormGroup;
  jwtHelper = new JwtHelperService();

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  onLogin(): void {
    if (this.loginForm.invalid) return;

    const { email, password } = this.loginForm.value;
    console.log(email)
    console.log(password)
    this.authService.login(email, password).subscribe({
      next: (response: any) => {
        const token = response.token;
        localStorage.setItem('token', token);

        const decodedToken = this.jwtHelper.decodeToken(token);
        const roles = decodedToken.roles || [];

        if (roles.includes('ROLE_ADMIN')) {
          this.router.navigate(['/admin']);
        } else if (roles.includes('ROLE_CLIENT')) {
          this.router.navigate(['/dashboard']);
        }
      },
      error: () => {
        alert('Credenciales incorrectas');
      },
    });
  }
}
