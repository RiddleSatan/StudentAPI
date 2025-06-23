package com.student.studentInfo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "course"
)
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_generator", sequenceName = "course_sequence_name", allocationSize = 1)
    private Long id;
    private String courses;

    public CourseModel() {
    }

    public CourseModel(String courses) {
        this.courses = courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getCourses() {
        return this.courses;
    }

}
