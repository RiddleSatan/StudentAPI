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
public StudentModel(String name, String age, String course);
```

# 📘 Why is a Non-Parameterized Constructor Needed in `StudentModel.java`?

In your `StudentModel` class, the **non-parameterized (default) constructor** is important for several key reasons:

---

## 🧱 1. Frameworks like Spring and Jackson Need It

When using `@RequestBody` in Spring Boot:

```java
@PostMapping("/add")
public String addStudent(@RequestBody StudentModel student) {
    ...
}
```

- Jackson (the library used to convert JSON into Java objects) uses **reflection** to create the object.
- It **requires a no-arg constructor** to create the object before setting its properties.

If the no-arg constructor is missing, you’ll get errors like:

> `"Cannot construct instance of StudentModel: no suitable constructor found"`

---

## 🔁 2. Your Parameterized Constructor Uses `this()`

```java
public StudentModel(String name, String age, String course) {
    this(); // Calls the no-arg constructor to initialize `id`
    ...
}
```

- This chaining means your parameterized constructor **depends on the existence** of the no-arg constructor.
- Without the no-arg constructor, `this()` would cause a compile-time error.

---

## 🧪 3. Useful for Manual Object Creation

Having a no-arg constructor allows object creation like this:

```java
StudentModel student = new StudentModel();
student.setName("Riddle");
student.setAge(21);
student.setCourse("CS");
```

This is useful during testing or when working in simple setups without constructors.

---

## ✅ Summary

| Reason | Explanation |
|--------|-------------|
| Jackson / Spring | Uses reflection to instantiate objects and requires a no-arg constructor |
| Constructor chaining | Your own constructor calls the default one via `this()` |
| Manual creation | Useful for creating and modifying object fields step-by-step |

> 🔑 **Always include a no-arg constructor** in Java POJOs when working with Spring Boot, Jackson, or similar frameworks.



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
