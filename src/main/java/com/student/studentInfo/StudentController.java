package com.student.studentInfo;


import com.student.studentInfo.model.StudentModel;
import com.student.studentInfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:5173")

public class StudentController {

    @Autowired
  private  StudentRepository studentRepository;

    @GetMapping
    public List<StudentModel> getAllStudents(){

        return  studentRepository.findAll();

    }

    @PostMapping
    public StudentModel addStudent(@RequestBody StudentModel student){
        StudentModel studentModel=new StudentModel();
        studentModel.setName(student.getName());
        studentModel.setAge(student.getAge());
        studentModel.setCourse(student.getCourse());
        studentModel.setEmail(student.getEmail());

        studentRepository.save(student);

        return studentModel;
    }


//    @DeleteMapping("/{id}")
//        public String deleteStudent(@PathVariable String id){
//
//            for(StudentModel student:studentList){
//                if(student.getId().equals(id)){
//                    studentList.remove(student);
//                return "Student Removed with ID: "+id;
//                }
//            }
//            return "Error: Student with ID: "+id+"NOT FOUND!";
//        }
}
