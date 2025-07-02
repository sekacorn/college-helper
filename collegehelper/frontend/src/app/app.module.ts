import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Import core feature components
import { ThemeSwitcherComponent } from './theme-switcher/theme-switcher.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { GradeCalculatorComponent } from './components/grade-calculator/grade-calculator.component';
import { CostCalculatorComponent } from './components/cost-calculator/cost-calculator.component';
import { BudgetCalculatorComponent } from './components/budget-calculator/budget-calculator.component';
import { PictureShareComponent } from './components/picture-share/picture-share.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    ThemeSwitcherComponent,
    LoginComponent,
    RegisterComponent,
    GradeCalculatorComponent,
    CostCalculatorComponent,
    BudgetCalculatorComponent,
    PictureShareComponent,
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
