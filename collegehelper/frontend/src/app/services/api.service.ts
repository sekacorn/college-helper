import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class ApiService {
  api = 'http://localhost:8080'; // This needs to point to port for  Spring Boot backend
  get headers() {
    return {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + (localStorage.getItem('token') || '')
      })
    };
  }

  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http.post(this.api + '/auth/login', { username, password }, { responseType: 'text' });
  }
  register(data: any) {
    return this.http.post(this.api + '/auth/register', data, { responseType: 'text' });
  }
  calculateGrade(data: any) {
    return this.http.post(this.api + '/api/student/calculate-grade', data, this.headers);
  }
  calculateCost(data: any) {
    return this.http.post(this.api + '/api/student/calculate-cost', data, this.headers);
  }
  generateBudgetExcel(data: any) {
    return this.http.post(this.api + '/api/student/generate-budget-excel', data, { ...this.headers, responseType: 'blob' });
  }
  uploadImage(file: File) {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post(this.api + '/api/student/upload', formData, this.headers);
  }
  getImages() {
    return this.http.get<string[]>(this.api + '/api/student/images', this.headers);
  }
  getAllUsers() {
    return this.http.get(this.api + '/api/admin/users', this.headers);
  }
}
