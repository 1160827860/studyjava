package com.darksouls.annotation;

public class Person {
    String name;
    int age;
    boolean sex;
    @Deprecated
    public void print(){
        System.out.println("我叫" + name + "我有" + age + "岁");
    }

    public Person() {

    }

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
