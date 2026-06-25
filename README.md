# Spring Boot MongoDB CRUD API

A production-ready RESTful CRUD (Create, Read, Update, Delete) API built using Spring Boot and MongoDB. This project serves as a reference architecture for layered application development and is intended for the final week project reference.

---

## 🛠️ Project Architecture

The project strictly enforces a standard, clean-layered architecture:

└── src/main/java/com/example/project
    ├── controller  <-- Exposes REST endpoints (@RestController) and handles HTTP mapping
    ├── service     <-- Contains core business logic and orchestration
    ├── repository  <-- Data access layer interfacing with MongoDB (@Repository)
    └── model       <-- Database documents mapped to MongoDB collections (@Document)

---

## 🚀 Complete Step-by-Step Guide

### Step 1: Install Prerequisites
Before you begin, ensure you have the following installed and running on your local machine:
1. Java Development Kit (JDK) 17 or higher.
2. MongoDB Community Server (running locally on port 27017) or a MongoDB Atlas Cloud Account.
3. Git installed for version control.
4. An API testing tool like Postman, Insomnia, or cURL.

### Step 2: Clone the Repository
Clone this reference project to your local workspace using git:
$git clone https://github.com/chynarendra/java-demo-project.git$ cd java-demo-project

### Step 3: Configure MongoDB Connection
Open the configuration file located at src/main/resources/application.properties and add your database credentials.

* Option A: For a Local MongoDB Instance (Default)
  spring.data.mongodb.uri=mongodb://localhost:27017/final_project_db

* Option B: For MongoDB Atlas (Cloud)
  spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.xxxxxx.mongodb.net/final_project_db?retryWrites=true&w=majority

### Step 4: Build the Project
Compile the Java source code and download all required Maven dependencies using the included Maven wrapper:
* On Linux/macOS:
  $ ./mvnw clean install
* On Windows (Command Prompt / PowerShell):
  $ .\mvnw clean install

### Step 5: Run the Application
Start the embedded Tomcat server inside Spring Boot:
* On Linux/macOS:
  $ ./mvnw spring-boot:run
* On Windows (Command Prompt / PowerShell):
  $ .\mvnw spring-boot:run

Once successfully started, the console will show that the application is running on port 8080 (http://localhost:8080).

---

## 📡 API Endpoints & Testing Guide

Use Postman or cURL to interact with the API. (Note: Replace /items below with your project's specific entity endpoint path like /students, /products, or /employees)

### 1. Create a Record (POST)
* URL: http://localhost:8080/api/v1/items
* Method: POST
* Headers: Content-Type: application/json
* Request Body (JSON):
{
  "name": "Sample Item",
  "description": "This is a sample description",
  "price": 299.99
}

### 2. Read All Records (GET)
* URL: http://localhost:8080/api/v1/items
* Method: GET

### 3. Read Single Record by ID (GET)
* URL: http://localhost:8080/api/v1/items/{id}
* Method: GET

### 4. Update an Existing Record (PUT)
* URL: http://localhost:8080/api/v1/items/{id}
* Method: PUT
* Headers: Content-Type: application/json
* Request Body (JSON):
{
  "name": "Updated Item Name",
  "description": "Updated description text",
  "price": 349.99
}

### 5. Delete a Record (DELETE)
* URL: http://localhost:8080/api/v1/items/{id}
* Method: DELETE

---

## 🛑 Troubleshooting Common Issues

* Connection Refused (MongoDB): Make sure your local MongoDB database service is actively running (mongod terminal command or started inside your system's services panel).
* Port 8080 Already in Use: If another app blocks port 8080, open application.properties and change the port configuration manually:
  server.port=8081
