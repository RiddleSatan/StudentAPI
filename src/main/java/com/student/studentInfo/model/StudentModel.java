package com.student.studentInfo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(
                name = "email",
                columnNames = "email"
        )
)
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "student_generator",
            allocationSize = 1,
            sequenceName = "student_sequence_name"
    )
    private Long id;

    private String name;
    private int age;

    @Column(name = "course_enrolled")
    private String course;

    //    @Column(unique = true)
    private String email;


    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public StudentModel() {
    }

    public StudentModel(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCourse() {
        return this.course;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }


}
