# 🎓 College Helper Spring Boot Backend

This is the backend service for **College Helper**, a modern web application designed to help students manage grades, budget for college, estimate costs, and more.  
Built with **Spring Boot 3**, secure JWT authentication, and clean RESTful APIs.

---

## 🚀 Features

- **JWT-based Authentication** (login/register)
- **Role-based Access Control:** Student, Moderator, Admin
- **Grade Calculator API** — find what you need on your final to pass
- **Semester Cost Calculator API** — estimate out-of-pocket costs
- **Budget Calculator API** — export Excel sheet from entries
- **Picture Share API** — upload and list images
- **Admin API** — manage users (view all users)
- **Production-ready structure:** easy to expand or plug in new features

---

## 🧑‍💻 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security** (JWT)
- **Spring Data JPA (Hibernate)**
- **Apache POI** (Excel support)
- **H2 Database** (dev/test; swap for PostgreSQL/MySQL in prod)
- **Lombok** (for cleaner code)

---

## 🗂️ Project Structure

src/main/java/com/collegehelper/
│
├── CollegeHelperApplication.java
├── config/
│ └── SecurityConfig.java
├── controllers/
│ ├── AdminController.java
│ ├── AuthController.java
│ ├── BudgetController.java
│ ├── GradeCalculatorController.java
│ ├── ImageController.java
│ └── SemesterCostController.java
├── dto/
│ ├── LoginRequest.java
│ └── RegisterRequest.java
├── models/
│ ├── BudgetEntry.java
│ └── User.java
├── repositories/
│ └── UserRepository.java
├── security/
│ └── JwtUtil.java
└── services/
├── BudgetService.java
├── GradeService.java
├── ImageService.java
├── SemesterCostService.java
└── UserService.java





---

## ⚡️ Getting Started

### 1. Prerequisites

- Java 17 or higher
- Maven 3.8+  
  (Maven Wrapper `./mvnw` included)

### 2. Clone the repo

```bash
git clone https://github.com/sekacorn/college-helper-backend.git
cd college-helper-backend
3. Configure the database (optional for dev)
Default uses in-memory H2 DB (see src/main/resources/application.properties)

To use PostgreSQL/MySQL, swap H2 dependency in pom.xml and update DB config.

4. Build & Run

# With Maven Wrapper:
```bash
./mvnw clean package
./mvnw spring-boot:run

# Or with system Maven:
```bash
mvn clean package
mvn spring-boot:run

# Or run the jar directly (after build):
java -jar target/collegehelper-0.0.1-SNAPSHOT.jar
5. API will be available at:
arduino


http://localhost:8080/
🗝️ API Endpoints (Sample)
POST /auth/register — Register new user

POST /auth/login — Login and receive JWT token

POST /api/student/calculate-grade — Calculate required grade

POST /api/student/calculate-cost — Calculate semester cost

POST /api/student/generate-budget-excel — Export budget to Excel

POST /api/student/upload — Upload image

GET /api/student/images — List uploaded images

GET /api/admin/users — List all users (admin only)

🛡️ Security
All sensitive endpoints require JWT in the Authorization: Bearer <token> header

Roles: STUDENT, MODERATOR, ADMIN

See SecurityConfig.java for detailed access rules

📄 Environment Config
Main config: src/main/resources/application.properties
Change JWT secret, DB URL, and other properties as needed.

💡 Notes
Passwords are stored as plaintext in dev for simplicity.
Before production, use password hashing (e.g. BCrypt).

Use cloud storage for images in production.

Add CORS config in SecurityConfig.java for frontend/backend integration.

🧩 Useful Scripts
build_and_run.sh — Build and run the backend (see scripts in this repo)

For Angular frontend, see /frontend and its README

📢 Contributing
Pull requests, bug reports, and suggestions welcome!

📄 License
MIT License