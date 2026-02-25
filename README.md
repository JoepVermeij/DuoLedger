# PairLedger

An AI-powered budgeting platform for couples to seamlessly manage joint and personal finances, featuring automated categorization and smart cost-cutting insights.

## Tech Stack

| Layer    | Technology                                  |
|----------|---------------------------------------------|
| Backend  | Kotlin, Spring Boot 3.3, Spring Security    |
| Database | PostgreSQL 16, Flyway migrations            |
| Frontend | Next.js 16, React, TypeScript, Tailwind CSS |
| Auth     | JWT (jjwt), BCrypt                          |

## Project Structure

```
backend/          Kotlin + Spring Boot API (port 8080)
frontend/         Next.js + TypeScript UI  (port 3000)
docker-compose.yml   PostgreSQL 16 + pgAdmin
```

## Getting Started

### Prerequisites

- Java 21
- Node.js 18+
- PostgreSQL 16 (or Docker)

### Database

**With Docker:**

```bash
docker compose up -d
```

**Without Docker (Homebrew):**

```bash
brew install postgresql@16
brew services start postgresql@16
createuser -s pairledger
createdb -O pairledger pairledger
psql -c "ALTER USER pairledger WITH PASSWORD 'pairledger';" pairledger
```

### Backend

```bash
cd backend
./gradlew bootRun
```

Flyway runs migrations automatically on startup. The API is available at `http://localhost:8080`.

### Frontend

```bash
cd frontend
npm install
npm run dev
```

The UI is available at `http://localhost:3000`. API calls are proxied to the backend.

## API Endpoints

| Method | Path                 | Auth     | Description         |
|--------|----------------------|----------|---------------------|
| GET    | `/api/health`        | No       | Health check        |
| POST   | `/api/auth/register` | No       | Create new account  |
| POST   | `/api/auth/login`    | No       | Sign in, receive JWT|

## Phase 1 - Completed

- Spring Boot 3 + Kotlin backend with Gradle, Flyway, and Spring Security
- PostgreSQL schema: `users`, `partnerships`, `partnership_members`, `ledgers`, `transactions`
- JWT authentication with register/login endpoints
- JPA entities and Spring Data repositories for all tables
- Next.js + TypeScript + Tailwind frontend with landing, login, register, and dashboard pages
- API proxy from Next.js to Spring Boot for local development
- Docker Compose setup for PostgreSQL and pgAdmin
