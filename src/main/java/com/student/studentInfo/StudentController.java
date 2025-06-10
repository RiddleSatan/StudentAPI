package com.student.studentInfo;


import com.student.studentInfo.model.StudentModel;
import com.student.studentInfo.repository.StudentRepository;
import com.student.studentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:5173")

public class StudentController {

    @Autowired
  private  StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "getAll")
    public List<StudentModel> getAllStudents(){
        return  studentRepository.findAll();
    }

   @GetMapping(path = "find/{id}")
   public StudentModel getStudent(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student with ID:"+id+ "not found"));
   }



    @PostMapping(path = "add")
    public StudentModel addStudent(@RequestBody StudentModel student){

        return studentService.addStudent(student);
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody StudentModel updatedStudent){

        StudentModel updated= studentService.updateStudent(id,updatedStudent);
         return ResponseEntity.ok("The student with ID:"+updated.getId()+" and Name: "+updated.getName() +" Has been Successfully Updated");
//      Optional<StudentModel> existingStudentOptional=studentRepository.findById(id);
//      if(existingStudentOptional.isPresent()){
//        StudentModel existingStudent=existingStudentOptional.get();
//        existingStudent.setName(updatedStudent.getName());
//        existingStudent.setAge(updatedStudent.getAge());
//        existingStudent.setEmail(updatedStudent.getEmail());
//        existingStudent.setCourse(updatedStudent.getCourse());
//        studentRepository.save(existingStudent);
//        return ResponseEntity.ok("The student with ID:"+existingStudent.getId()+" and Name: "+existingStudent.getName() +" Has been Successfully Updated");
//      }else{
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Student with ID: "+ id+" Not found");
//      }
    }



    @DeleteMapping(path = "delete/{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable Long id){

      return studentService.deleteStudent(id);
        }

        @DeleteMapping(path = "deleteAll")
       public String deleteAll(){
       return studentService.deleteAll();

        }



}



