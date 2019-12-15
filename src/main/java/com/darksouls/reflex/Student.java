package com.darksouls.reflex;

public class Student  extends Person {

    String school;
    @Override
    public void print() {
        System.out.println("Student{" +
                "school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}');
    }

    public Student() {
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
