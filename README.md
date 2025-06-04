# 📘 Student Information REST API

A simple Spring Boot-based REST API for managing student records using in-memory storage (no database). This project is built for learning purposes and demonstrates basic REST operations and integration with a React frontend.

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

| Field    | Type     | Description                          |
|----------|----------|--------------------------------------|
| `id`     | `String` | Unique identifier (auto-generated)   |
| `name`   | `String` | Name of the student                  |
| `age`    | `String` | Age of the student (stored as String)|
| `course` | `String` | Course the student is enrolled in    |
| `email`  | `String` | Student email *(from frontend, currently unused in backend)* |

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

> **Note**: `email` is currently not stored in the backend model.

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
  "course": "Computer Science",
  "email": "john@example.com"
}
```

> ⚠️ Note: `email` is accepted on frontend but not stored in backend yet.

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

## 🔗 Frontend Integration

The React frontend connects to this API at:

```
http://localhost:8080/students
```

Make sure to enable CORS in the backend:

```java
@CrossOrigin("http://localhost:5173")
```

Frontend features:

- Add new student via form
- Display student list in a table
- Delete a student by ID

---

## 🚧 Limitations

- Data is not persistent (in-memory only)
- `email` field is not stored in the backend
- Age stored as string
- No input validation or error handling

---

## 💡 Learning Focus

- Building RESTful API with Spring Boot
- Using annotations: `@RestController`, `@RequestMapping`, etc.
- Handling path variables and request bodies
- Generating UUIDs
- Connecting frontend (React) with Spring Boot backend

---

## 📈 Suggested Next Steps

- Add PUT endpoint for update
- Add `email` field in backend
- Add validation using `@Valid`
- Use in-memory DB (e.g., H2)
- Integrate Swagger UI
- Use Lombok to reduce boilerplate

---

> _Built for educational purposes with ❤️, Spring Boot & React._
