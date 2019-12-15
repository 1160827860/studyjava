package com.darksouls.annotation;

public class Student extends Person {
    String school;

    @Override
    public void print(){

    }

    public Student(String school) {
        this.school = school;
    }

    public Student(String name, int age, boolean sex, String school) {
        super(name, age, sex);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
