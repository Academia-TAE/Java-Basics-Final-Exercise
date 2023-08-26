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
    public int getEnrolledStudentCount() {
        return students.size();
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
