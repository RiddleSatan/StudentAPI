package com.student.studentInfo.service;

import com.student.studentInfo.model.CourseModel;
import com.student.studentInfo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseModel addCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public ResponseEntity<String> deleteCourse(Long id) {
        Optional<CourseModel> course = courseRepository.findById(id);

        if (course.isPresent()) {
            courseRepository.deleteById(id);
            return ResponseEntity.ok("The Course with" + id + "was Removed Successfully !");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course with id : " + id + "NOT_FOUND !");
        }
    }

    public CourseModel updateCourse(CourseModel courseModel) {
        CourseModel exisitingCourse = courseRepository.findById(courseModel.getId()).orElseThrow(() -> new RuntimeException("Course with id:" + courseModel.getId() + "Not found"));
        exisitingCourse.setCourses(courseModel.getCourses());
        return courseRepository.save(exisitingCourse);
    }
}
