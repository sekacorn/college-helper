import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { GradeCalculatorComponent } from './components/grade-calculator/grade-calculator.component';
import { CostCalculatorComponent } from './components/cost-calculator/cost-calculator.component';
import { BudgetCalculatorComponent } from './components/budget-calculator/budget-calculator.component';
import { PictureShareComponent } from './components/picture-share/picture-share.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { RoleGuard } from './guards/role.guard';

const routes: Routes = [
  { path: '', redirectTo: 'grade-calculator', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'grade-calculator', component: GradeCalculatorComponent, canActivate: [RoleGuard] },
  { path: 'cost-calculator', component: CostCalculatorComponent, canActivate: [RoleGuard] },
  { path: 'budget-calculator', component: BudgetCalculatorComponent, canActivate: [RoleGuard] },
  { path: 'picture-share', component: PictureShareComponent, canActivate: [RoleGuard] },
  { path: 'admin', component: AdminDashboardComponent, canActivate: [RoleGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
