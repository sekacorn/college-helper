import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-grade-calculator',
  templateUrl: './grade-calculator.component.html'
})
export class GradeCalculatorComponent {
  currentScore = 80;
  targetScore = 70;
  totalPossible = 100;
  finalWeight = 40;
  needed: number|null = null;

  constructor(private api: ApiService) {}

  calculate() {
    this.api.calculateGrade({
      currentScore: this.currentScore,
      targetScore: this.targetScore,
      totalPossible: this.totalPossible,
      finalWeight: this.finalWeight
    }).subscribe((res: any) => this.needed = res.needed);
  }
}
