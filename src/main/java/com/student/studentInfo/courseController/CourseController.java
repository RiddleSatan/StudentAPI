package com.student.studentInfo.courseController;

import com.student.studentInfo.model.CourseModel;
import com.student.studentInfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(path = "getAllCourse")
    public List<CourseModel> getAllCourse() {
        return courseService.getAllCourses();
    }

    @PostMapping(path = "deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    @PostMapping(path = "addCourse")
    public CourseModel addCourse(@RequestBody CourseModel courseModel) {
        return courseService.addCourse(courseModel);
    }

    @PutMapping(path = "updateCourse")
    public CourseModel updateCourse(@RequestBody CourseModel course) {
        return courseService.updateCourse(course);
    }

}
