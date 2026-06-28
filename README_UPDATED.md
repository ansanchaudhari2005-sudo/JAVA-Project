# Spring Boot MongoDB CRUD API

A production-ready RESTful CRUD API built using Spring Boot and MongoDB. This project now includes Docker support for local development.

---

## 🚀 Project Structure

```
java-demo-project/
  ├── Dockerfile
  ├── docker-compose.yml
  ├── pom.xml
  ├── src/
  └── README.md
```

## 🔧 Docker Setup

### Build and run with Docker Compose

```bash
docker compose up --build
```

This starts:
- Spring Boot app on `http://localhost:8080`
- MongoDB on `localhost:27017`

### Stop the services

```bash
docker compose down
```

## 📦 Local Build

```bash
./mvnw clean package
```

Run locally:

```bash
./mvnw spring-boot:run
```

## 🌐 API Endpoints

- `POST /journal`
- `GET /journal`
- `GET /journal/{id}`
- `PUT /journal/{id}`
- `DELETE /journal/{id}`

## 🧩 MongoDB Configuration

The app uses `MONGO_URI` from environment variables.

Default in `docker-compose.yml`:

```yaml
MONGO_URI=mongodb://mongo:27017/journaldb
```
