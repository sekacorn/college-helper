import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html'
})
export class AdminDashboardComponent implements OnInit {
  users: any[] = [];
  constructor(private api: ApiService) {}
  ngOnInit() {
    this.api.getAllUsers().subscribe((data: any) => this.users = data);
  }
}
