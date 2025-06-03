
# 📘 Student Information REST API

A simple Spring Boot-based REST API for managing student records using in-memory storage (no database). This project is built for learning purposes and demonstrates basic REST operations.

---

## 🧱 Project Structure

```
com.student.studentInfo
├── StudentController.java  # Handles HTTP requests
└── StudentModel.java       # Represents student entity
```

---

## 📝 StudentModel.java

### Description

Represents a student with the following properties:

| Field   | Type     | Description                          |
|---------|----------|--------------------------------------|
| `id`    | `String` | Unique identifier (auto-generated)   |
| `name`  | `String` | Name of the student                  |
| `age`   | `String` | Age of the student (stored as String)|
| `course`| `String` | Course the student is enrolled in    |

### Constructor

```java
public StudentModel(String name, String age, String course)
```

- Automatically assigns a unique UUID to `id`.

### Getters and Setters

- `getId()`: Returns the UUID  
- `getName()`, `setName(String)`  
- `getAge()`, `setAge(int)`  
- `getCourse()`, `setCourse(String)`

---

## 🌐 StudentController.java

### Base URL

```
/students
```

---

### 📥 POST `/students`

**Description**: Adds a new student.

**Request Body (JSON)**:
```json
{
  "name": "John",
  "age": "22",
  "course": "Computer Science"
}
```

**Response**:
```
student Added: John
```

---

### 📤 GET `/students`

**Description**: Fetches all student records.

**Response**:
```json
[
  {
    "id": "c9a1-f35d-...",
    "name": "John",
    "age": "22",
    "course": "Computer Science"
  }
]
```

---

### ❌ DELETE `/students/{id}`

**Description**: Deletes a student by ID.

**Response on Success**:
```
Student Removed with ID: {id}
```

**Response on Failure**:
```
Error: Student with ID: {id} NOT FOUND!
```

---

## 🚧 Limitations

- Data is not persistent (stored in memory).  
- Age is stored as a string.  
- No input validation or error handling.  
- No frontend – API-only.

---

## 💡 Learning Focus

This project helps you learn:

- How to create a RESTful API using Spring Boot  
- Using annotations like `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@DeleteMapping`  
- How to handle request bodies and path variables  
- How to use `UUID` for unique IDs

---

## 📈 Suggested Next Steps

- Add `PUT` endpoint for updating student data  
- Use `@Valid` for input validation  
- Integrate with an in-memory DB like H2 (later)  
- Add Swagger UI for API testing  
- Use Lombok to reduce boilerplate code

---

> _Built for educational purposes with ❤️ and Spring Boot._
