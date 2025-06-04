package com.student.studentInfo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:5173")

public class StudentController {
   List<StudentModel> studentList=new ArrayList<>();
    @GetMapping
    public List<StudentModel> getAllStudents(){
        return studentList;
    }

    @PostMapping
    public StudentModel addStudent(@RequestBody StudentModel student){
        studentList.add(student);
        return student;
    }


    @DeleteMapping("/{id}")
        public String deleteStudent(@PathVariable String id){

            for(StudentModel student:studentList){
                if(student.getId().equals(id)){
                    studentList.remove(student);
                return "Student Removed with ID: "+id;
                }
            }
            return "Error: Student with ID: "+id+"NOT FOUND!";
        }
}
