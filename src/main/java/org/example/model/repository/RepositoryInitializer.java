package org.example.model.repository;

import org.example.model.IRepositoryInitializer;
import org.example.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryInitializer implements IRepositoryInitializer {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Subject> subjects;
    public RepositoryInitializer(){
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        this.initializeData();
    }
    public void initializeData() {
        teachers.add(new FullTimeTeacher("John Doe", 50000, 5));
        teachers.add(new FullTimeTeacher("Jane Smith", 55000, 8));
        teachers.add(new PartTimeTeacher("Michael Johnson", 30, 2, 10));
        teachers.add(new PartTimeTeacher("Emily Brown", 25, 3, 8));

        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));
        students.add(new Student("Diana", 23));
        students.add(new Student("Eva", 24));
        students.add(new Student("Frank", 25));

        Subject subject1 = new Subject("Math", "Room 101", teachers.get(0));
        Subject subject2 = new Subject("English", "Room 102", teachers.get(1));
        Subject subject3 = new Subject("Science", "Room 103", teachers.get(2));
        Subject subject4 = new Subject("History", "Room 104", teachers.get(3));

        subject1.enrollStudent(students.get(0));
        subject1.enrollStudent(students.get(1));
        subject2.enrollStudent(students.get(2));
        subject2.enrollStudent(students.get(3));
        subject3.enrollStudent(students.get(4));
        subject4.enrollStudent(students.get(5));

        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
    }

    @Override
    public List<Teacher> getStoragedTeachers() {
        return this.teachers;
    }

    @Override
    public List<Student> getStoragedStudents() {
        return this.students;
    }

    @Override
    public List<Subject> getStoragedSubjects() {
        return this.subjects;
    }
}
