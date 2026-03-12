# 🚀 Spring Boot CRUD API with MySQL

A complete RESTful CRUD API for Employee Management built with **Spring Boot**, **MySQL**, and tested via **Postman**.

---

## 🛠️ Tech Stack

| Technology      | Version  |
|-----------------|----------|
| Java            | 17       |
| Spring Boot     | 3.2.0    |
| Spring Data JPA | 3.2.0    |
| MySQL           | 8.x      |
| Maven           | 3.x      |
| Lombok          | Latest   |

---

## 📁 Project Structure

```
springboot-crud/
├── src/main/java/com/example/crud/
│   ├── CrudApplication.java          ← Main entry point
│   ├── controller/
│   │   └── EmployeeController.java   ← REST API endpoints
│   ├── service/
│   │   ├── EmployeeService.java      ← Service interface
│   │   └── EmployeeServiceImpl.java  ← Business logic
│   ├── repository/
│   │   └── EmployeeRepository.java   ← JPA Repository
│   ├── model/
│   │   └── Employee.java             ← Entity/Model
│   └── exception/
│       ├── ResourceNotFoundException.java
│       └── GlobalExceptionHandler.java
├── src/main/resources/
│   └── application.properties        ← DB config
├── database-setup.sql                ← MySQL setup script
├── SpringBoot-CRUD-Postman-Collection.json  ← Postman collection
└── pom.xml
```

---

## ⚙️ Setup Instructions

### 1. Prerequisites
- Java 17+
- MySQL 8.x running locally
- Maven 3.x
- Postman (for testing)

### 2. Database Setup
```sql
-- Open MySQL and run:
CREATE DATABASE IF NOT EXISTS cruddb;
```
Or run the full `database-setup.sql` file in MySQL Workbench.

### 3. Configure Database Credentials
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cruddb?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password   ← Change this!
```

### 4. Run the Application
```bash
# Using Maven
mvn spring-boot:run

# Or build and run JAR
mvn clean install
java -jar target/springboot-crud-1.0.0.jar
```

Server starts at: **http://localhost:8080**

---

## 📡 API Endpoints

| Method   | Endpoint                              | Description               |
|----------|---------------------------------------|---------------------------|
| `POST`   | `/api/employees`                      | Create a new employee     |
| `GET`    | `/api/employees`                      | Get all employees         |
| `GET`    | `/api/employees/{id}`                 | Get employee by ID        |
| `PUT`    | `/api/employees/{id}`                 | Update employee by ID     |
| `DELETE` | `/api/employees/{id}`                 | Delete employee by ID     |
| `GET`    | `/api/employees/department/{dept}`    | Get by department         |
| `GET`    | `/api/employees/search?name={name}`   | Search by name            |

---

## 📋 Sample Request & Response

### ✅ Create Employee (POST)
**URL:** `http://localhost:8080/api/employees`

**Request Body:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "department": "Engineering",
  "salary": 75000.00,
  "phone": "+91-9876543210"
}
```

**Response (201 Created):**
```json
{
  "message": "Employee created successfully",
  "data": {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "department": "Engineering",
    "salary": 75000.0,
    "phone": "+91-9876543210"
  }
}
```

---

## 🧪 Postman Testing

1. Open Postman
2. Click **Import** → Select `SpringBoot-CRUD-Postman-Collection.json`
3. The collection includes all 8 pre-configured requests
4. Run them in order (Create first, then read/update/delete)

---

## 🔒 Validation Rules

| Field        | Rule                          |
|--------------|-------------------------------|
| `firstName`  | Not blank                     |
| `lastName`   | Not blank                     |
| `email`      | Not blank, valid email format |
| `department` | Not blank                     |
| `salary`     | Not null                      |

---

## 📝 HTTP Status Codes

| Code | Meaning                  |
|------|--------------------------|
| 200  | OK - Success             |
| 201  | Created                  |
| 400  | Bad Request (validation) |
| 404  | Employee Not Found       |
| 500  | Internal Server Error    |
