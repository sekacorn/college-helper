import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  username = '';
  password = '';
  error = '';

  constructor(private api: ApiService, private router: Router) {}

  login() {
    this.api.login(this.username, this.password).subscribe(
      (token: any) => {
        localStorage.setItem('token', token);
        this.router.navigate(['/grade-calculator']);
      },
      () => this.error = 'Invalid login.'
    );
  }
}
