package org.example.controller.service;

import org.example.controller.IUniversityTracker;
import org.example.model.IRepositoryInitializer;
import org.example.model.domain.*;
import org.example.model.repository.RepositoryInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class UniversityTracker implements IUniversityTracker {
    private IRepositoryInitializer repository;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Subject> subjects;

    public UniversityTracker() {
        repository = new RepositoryInitializer();
        teachers = repository.getStoragedTeachers();
        students = repository.getStoragedStudents();
        subjects = repository.getStoragedSubjects();
    }

    @Override
    public void printStudents() {
        students.forEach(student -> System.out.println("    -> " + student));
    }
    @Override
    public void printTeachers() {
        AtomicInteger index = new AtomicInteger(1);
        teachers.forEach(teacher -> System.out.println("[" + index.getAndIncrement() + "] -> " + teacher));
    }

    @Override
    public void printClasses() {
        System.out.println("Classes:");
        IntStream.range(0, subjects.size())
                .mapToObj(index -> (index + 1) + ". " + subjects.get(index).getName())
                .forEach(System.out::println);
    }

    @Override
    public void printClassData(int classIndex) {
        subjects.stream()
                .filter(subject -> subjects.indexOf(subject) == classIndex)
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Override
    public void createNewStudent(String name, int age, int subjectNumber) {
        Student newStudent = new Student(name, age);
        students.add(newStudent);
        enrollStudentInSubject(newStudent, subjectNumber);
        System.out.println("Student created and added to the list.");
    }

    @Override
    public void createNewClass(String className, String classroom, int teacherIndex, String studentIndexesInput) {
        String[] studentIndexes = studentIndexesInput.split(",");
        List<Student> selectedStudents = new ArrayList<>();
        for (String index : studentIndexes) {
            int studentIndex = Integer.parseInt(index.trim());
            selectedStudents.add(students.get(studentIndex));
        }

        Subject newSubject = new Subject(className, classroom, teachers.get(teacherIndex-1));
        for (Student student : selectedStudents) {
            newSubject.enrollStudent(student);
        }
        subjects.add(newSubject);
        System.out.println("Class created and added to the list.");
    }

    @Override
    public void listClassesForStudent(int studentId) {
        System.out.println("Classes for Student with ID " + studentId + ":");
        subjects.stream()
                .filter(subject -> subject.getStudents().stream()
                        .anyMatch(student -> student.getId() == studentId))
                .forEach(subject -> System.out.println(subject.getName()));
    }

    private void enrollStudentInSubject(Student student, int subjectNumber) {
        if (subjectNumber >= 1 && subjectNumber <= subjects.size()) {
            subjects.get(subjectNumber - 1).enrollStudent(student);
        } else {
            System.out.println("Invalid Subject Number. Student not enrolled.");
        }
    }
}