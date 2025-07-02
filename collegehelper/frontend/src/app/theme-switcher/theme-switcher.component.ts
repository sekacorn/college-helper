import { Component } from '@angular/core';

@Component({
  selector: 'app-theme-switcher',
  templateUrl: './theme-switcher.component.html'
})
export class ThemeSwitcherComponent {
  themes = [
    { name: 'Cerulean', file: 'assets/themes/cerulean.min.css' },
    { name: 'Cosmo', file: 'assets/themes/cosmo.min.css' }
  ];

  switchTheme(themeFile: string) {
    // Dynamically switch CSS by changing the href of the main theme <link>
    const el = document.getElementById('theme-link') as HTMLLinkElement;
    if (el) el.href = themeFile;
  }
}
