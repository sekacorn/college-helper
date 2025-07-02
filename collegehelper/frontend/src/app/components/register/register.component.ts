import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  username = '';
  password = '';
  role = 'STUDENT';
  error = '';
  constructor(private api: ApiService, private router: Router) {}

  register() {
    this.api.register({ username: this.username, password: this.password, role: this.role }).subscribe(
      () => this.router.navigate(['/login']),
      () => this.error = 'Registration failed.'
    );
  }
}
