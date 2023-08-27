package org.example.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected String name;
    protected String classroom;
    protected Teacher teacher;
    protected List<Student> students;

    public Subject(String name, String classroom, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        StringBuilder studentList = new StringBuilder();
        for (Student student : students) {
            studentList.append("\n  -> ").append(student.toString());
        }
        return "Subject - Name: " + name +
                ", Classroom: " + classroom +
                ", Teacher: " + teacher.getName() +
                ", Enrolled Students: " + students.size() +
                studentList;
    }
}
