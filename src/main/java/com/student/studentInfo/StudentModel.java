package com.student.studentInfo;

import java.lang.reflect.Array;
import java.util.UUID;

public class StudentModel {
    private final String id;
    private String name;
    private String age;
    private String course;

    public StudentModel() {
        this.id = UUID.randomUUID().toString(); // set ID here
    }
public StudentModel(String name, String age, String course) {
    this();
    this.name = name;
    this.age = age;
    this.course = course;
}

   public void setName(String name){
        this.name=name;
    }
   public void setAge(int age){
        this.age=Integer.toString(age);
    }

  public  void setCourse(String course){
        this.course=course;
    }

    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String getCourse(){
        return this.course;
    }

    public String getId(){
    return this.id;
    }

}
