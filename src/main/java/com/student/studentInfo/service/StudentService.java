package com.student.studentInfo.service;

import com.student.studentInfo.dto.StudentDto;
import com.student.studentInfo.model.StudentModel;
import com.student.studentInfo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentDto getStudent(Long id) {
        StudentModel student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID:" + id + "not found"));
        return convertEntityToDto(student);
    }

    public StudentDto addStudent(StudentModel student) {
        StudentModel newStudent = studentRepository.save(student);

        return convertEntityToDto(newStudent);
    }

    public StudentDto updateStudent(Long id, StudentModel updatedStudent) {
        StudentModel existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id: " + id + "not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());
        studentRepository.save(existingStudent);

        return convertEntityToDto(existingStudent);
    }


    public ResponseEntity<String> deleteStudent(Long id) {

        Optional<StudentModel> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student with ID " + id + "has been deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Student with id= " + id + "not found");
    }

    public String deleteAll() {
        try {
            studentRepository.deleteAll();
            return "Deleted all Records Successfully";
        } catch (Exception e) {
            return "Something Went Wrong" + e;
        }
    }

    private StudentDto convertEntityToDto(StudentModel studentModel) {
        StudentDto studentDto = new StudentDto();
        studentDto = modelMapper.map(studentModel, StudentDto.class);
        return studentDto;
    }

}
