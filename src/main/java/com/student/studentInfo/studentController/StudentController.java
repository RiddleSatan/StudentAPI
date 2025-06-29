package com.student.studentInfo.studentController;


import com.student.studentInfo.dto.StudentDto;
import com.student.studentInfo.model.StudentModel;
import com.student.studentInfo.repository.StudentRepository;
import com.student.studentInfo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "getAll")
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "find/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }


    @PostMapping(path = "add")
    public StudentDto addStudent(@RequestBody @Valid StudentModel student) {

        return studentService.addStudent(student);
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentModel updatedStudent) {

        StudentDto updated = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok("The student with ID:" + updated.getId() + " and Name: " + updated.getName() + " Has been Successfully Updated");
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @DeleteMapping(path = "deleteAll")
    public String deleteAll() {
        return studentService.deleteAll();

    }


}



