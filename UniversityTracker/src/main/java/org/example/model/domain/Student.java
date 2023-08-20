package org.example.model.domain;

public class Student {
    protected String name;
    protected int id;
    protected int age;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public String getName() {
        return name;
    }
}
