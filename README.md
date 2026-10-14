# ms-users (User Management Microservice)

A Spring Boot microservice responsible for handling user authentication, registration, and session management.

## Features
* **User Registration:** Secure account creation.
* **Authentication:** User login validation and secure token generation[cite: 1].
* **Session Management:** Utilizes Redis for high-performance session caching and token validation (`RedisService`)[cite: 1].
* **Order Validation:** Intercepts and validates active user sessions before allowing order placements[cite: 1].

## Tech Stack
* **Java**
* **Spring Boot** (Web, Data JPA)
* **Redis** (Token caching & session storage)
* **PostgreSQL** (Relational data persistence)
* **Gradle**

## Project Structure
The application follows a standard layered architecture:
* `controller/`: REST API endpoints (`UserController`)[cite: 1].
* `service/`: Core business logic for users and Redis integration[cite: 1].
* `repository/`: Spring Data JPA interfaces for database access[cite: 1].
* `entity/`: Database models representing the application state[cite: 1].
* `dto/`: Data Transfer Objects for clean API request/response payloads (`UserLoginDto`, `UserRegistrationDto`, etc.)[cite: 1].

## Local Development Setup

### Prerequisites
* Java 17+
* Redis (running on default port `6379`)
* PostgreSQL
* Gradle

### Installation & Running
1. Clone the repository:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/ms-users.git](https://github.com/YOUR_USERNAME/ms-users.git)
