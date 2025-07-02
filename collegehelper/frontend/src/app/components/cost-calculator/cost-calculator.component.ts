import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-cost-calculator',
  templateUrl: './cost-calculator.component.html'
})
export class CostCalculatorComponent {
  tuition = 0;
  living = 0;
  books = 0;
  scholarships = 0;
  total: number|null = null;

  constructor(private api: ApiService) {}

  calculate() {
    this.api.calculateCost({
      tuition: this.tuition,
      living: this.living,
      books: this.books,
      scholarships: this.scholarships
    }).subscribe((res: any) => this.total = res.total ?? res); // Backend may just return a number
  }
}
