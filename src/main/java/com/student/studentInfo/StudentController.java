package com.student.studentInfo;


import com.student.studentInfo.model.StudentModel;
import com.student.studentInfo.repository.StudentRepository;
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
      StudentModel  newStudent =  studentRepository.save(student);
        return newStudent;
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody StudentModel updatedStudent){
      Optional<StudentModel> existingStudentOptional=studentRepository.findById(id);

      if(existingStudentOptional.isPresent()){
        StudentModel existingStudent=existingStudentOptional.get();
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());
        studentRepository.save(existingStudent);
        return ResponseEntity.ok("The student with ID:"+existingStudent.getId()+" and Name: "+existingStudent.getName() +" Has been Successfully Updated");
      }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Student with ID: "+ id+" Not found");
      }
    }



    @DeleteMapping(path = "delete/{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable Long id){
      Optional<StudentModel> student= studentRepository.findById(id);
             if(student.isPresent()){
             studentRepository.deleteById(id);
             return ResponseEntity.ok("student with ID "+id+"has been deleted");
             }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Student with id= "+id+"not found");

        }

        @DeleteMapping(path = "deleteAll")
       public String deleteAll(){
      try {
         studentRepository.deleteAll();
        return "Deleted all Records Successfully";
      }catch (Exception e){
        return "Something Went Wrong"+e;
      }



        }

}



