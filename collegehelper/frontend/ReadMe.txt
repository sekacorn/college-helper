# 🎓 College Helper Angular Frontend

This is the frontend for **College Helper** — a modern web app to help students track grades, budget for college, calculate costs, share resources, and more.  
Built with [Angular](https://angular.io/), [Bootstrap](https://getbootstrap.com/), and [Bootswatch](https://bootswatch.com/) themes for a beautiful, responsive UI.

---

## 🚀 Features

- **Role-based login and registration** (Student, Moderator, Admin)
- **Grade Calculator:** Find out what you need to score on your final to pass
- **Semester Cost Calculator:** Estimate your out-of-pocket cost
- **Budget Calculator:** Enter your expenses and export to Excel
- **Picture Share:** Upload and share study resources and screenshots
- **Admin Dashboard:** View all users (admin only)
- **Live Bootstrap Theme Switcher:** Easily swap between Cerulean and Cosmo themes

---

## 📦 Project Structure

src/
├── app/
│ ├── app.module.ts
│ ├── app-routing.module.ts
│ ├── services/
│ │ └── api.service.ts
│ ├── guards/
│ │ └── role.guard.ts
│ ├── theme-switcher/
│ │ ├── theme-switcher.component.ts
│ │ └── theme-switcher.component.html
│ └── components/
│ ├── login/
│ ├── register/
│ ├── grade-calculator/
│ ├── cost-calculator/
│ ├── budget-calculator/
│ ├── picture-share/
│ └── admin-dashboard/
├── assets/
│ └── themes/
│ ├── cerulean.min.css
│ └── cosmo.min.css
└── index.html



Edit

---

## ⚡️ Getting Started

### Prerequisites

- [Node.js](https://nodejs.org/) (18.x+ recommended)
- [npm](https://www.npmjs.com/) (comes with Node.js)
- [Angular CLI](https://angular.io/cli) (recommended for devs):  
  ```bash
  npm install -g @angular/cli
1. Clone the repo

```bash
Edit
git clone https://github.com/sekacorn/college-helper-frontend.git
cd college-helper-frontend
2. Install dependencies

```bash
npm install
3. Run the development server
bash

```bash
npm start
Or (if using Angular CLI):

```bash
ng serve --open
App will run at http://localhost:4200.

4. Build for production
bash

```bash
npm run build
🎨 Bootstrap Theme Switcher
Default theme: Cerulean (Bootswatch)

Alternate theme: Cosmo (Bootswatch)

All theme CSS files are in src/assets/themes/

Users can switch themes live via the theme dropdown at the top of each page

To add more themes:

Download any .min.css from Bootswatch

Place it in src/assets/themes/

Add it to the theme list in theme-switcher.component.ts

🔑 API and Backend
This app connects to the College Helper Spring Boot backend

Make sure the backend is running (default: http://localhost:8080)

You can change the API URL in src/app/services/api.service.ts (api field)

🛡️ Authentication & Roles
JWT tokens are stored in localStorage

Protected routes require login (see role.guard.ts)

Admin dashboard only accessible to Admin users

✨ Key NPM Packages
Bootstrap (UI Framework)

Bootswatch (Themes)

file-saver (Budget Excel downloads)

@angular/common, @angular/forms, @angular/router, etc.

🧑‍💻 Scripts
npm start — Run development server

npm run build — Build production bundle

🤝 Contributing
Open to PRs, feedback, and issues!
If you have an idea for a new feature or want to improve the UI, just open an issue or PR.

📄 License
MIT License

