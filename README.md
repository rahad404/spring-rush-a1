# Social Media Backend API
### UIU Developers Hub — Spring-Rush Season 2

A simple backend system for a social media platform, built with **Spring Boot**. This project demonstrates RESTful API design, the DTO pattern, layered architecture, and basic CRUD operations with postgresql/H2 database.

---

## Features

- **User Management** — Create, retrieve, and update user profiles with unique email enforcement
- **Post Management** — Create and browse posts with a 280-character content limit
- **Soft Delete** — Deleting a post marks it inactive instead of removing it from the database; only active posts appear in the feed
- **Input Validation** — Invalid or empty requests return proper HTTP error responses
- **DTO Pattern** — Clean separation between API-facing data (Request/Response DTOs) and internal entities

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.6 |
| Database | PostgreSQL | H2
| ORM | Spring Data JPA / Hibernate |
| Validation | Spring Boot Validation (`jakarta.validation`) |
| Build Tool | Maven |

---

## API Endpoints

### Users
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/users` | Create a new user |
| `GET` | `/users/{id}` | Get a user by ID |
| `PUT` | `/users/{id}` | Update a user's bio |

### Posts
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/posts` | Create a new post |
| `GET` | `/posts` | Get all active posts |
| `DELETE` | `/posts/{id}` | Soft-delete a post |

---

## Getting Started

**Prerequisites:** Java 21+, Maven,(optional: to use PostgreSQL, uncomment the lines(change password with your db password) in application.properties and comment out the H2 configuration)

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name
   ```
[Optional Step if use postgresql]
2. **Configure the database** in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

---

## Assignment

This project was built as a submission for the **UIU Developers Hub — Spring-Rush Season 2** program.