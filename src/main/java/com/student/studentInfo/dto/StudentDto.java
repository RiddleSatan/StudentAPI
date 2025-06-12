package com.student.studentInfo.dto;

import jakarta.annotation.Nonnull;

public class StudentDto {

    private Long id;
    private String name;

    private int age;
    private String email;
    private String course;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCourse() {
        return this.course;
    }

    public Long getId() {
        return this.id;
    }


}
