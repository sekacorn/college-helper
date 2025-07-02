import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-budget-calculator',
  templateUrl: './budget-calculator.component.html'
})
export class BudgetCalculatorComponent {
  entries: {category: string, amount: number}[] = [{category: '', amount: 0}];
  constructor(private api: ApiService) {}
  addEntry() { this.entries.push({category: '', amount: 0}); }
  removeEntry(i: number) { this.entries.splice(i,1); }
  downloadExcel() {
    this.api.generateBudgetExcel(this.entries).subscribe(blob => {
      saveAs(blob, 'budget.xlsx');
    });
  }
}
