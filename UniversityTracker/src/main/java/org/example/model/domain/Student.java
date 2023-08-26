package org.example.model.domain;

public class Student {
    protected String name;
    protected static int singleID = 0;
    protected int id = 0;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = this.singleID++;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
