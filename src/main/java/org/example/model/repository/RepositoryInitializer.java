package org.example.model.repository;

import org.example.model.IRepositoryInitializer;
import org.example.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryInitializer implements IRepositoryInitializer {
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();

    public RepositoryInitializer() {
        initializeTeachers();
        initializeStudents();
        initializeSubjects();
    }

    private void initializeTeachers() {
        teachers.add(new FullTimeTeacher("John Doe", 50000, 5));
        teachers.add(new FullTimeTeacher("Jane Smith", 55000, 8));
        teachers.add(new PartTimeTeacher("Michael Johnson", 30, 2, 10));
        teachers.add(new PartTimeTeacher("Emily Brown", 25, 3, 8));
    }

    private void initializeStudents() {
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));
        students.add(new Student("Diana", 23));
        students.add(new Student("Eva", 24));
        students.add(new Student("Frank", 25));
    }

    private void initializeSubjects() {
        Subject subject1 = createSubject("Math", "Room 101", teachers.get(0), students.get(0), students.get(1));
        Subject subject2 = createSubject("English", "Room 102", teachers.get(1), students.get(2), students.get(3));
        Subject subject3 = createSubject("Science", "Room 103", teachers.get(2), students.get(4));
        Subject subject4 = createSubject("History", "Room 104", teachers.get(3), students.get(5));

        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
    }

    private Subject createSubject(String name, String room, Teacher teacher, Student... students) {
        Subject subject = new Subject(name, room, teacher);
        for (Student student : students) {
            subject.enrollStudent(student);
        }
        return subject;
    }

    @Override
    public List<Teacher> getStoragedTeachers() {
        return teachers;
    }

    @Override
    public List<Student> getStoragedStudents() {
        return students;
    }

    @Override
    public List<Subject> getStoragedSubjects() {
        return subjects;
    }
}
