package org.example.controller.service;

import org.example.controller.IUniversityTracker;
import org.example.model.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UniversityTracker implements IUniversityTracker {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Subject> subjects;

    public UniversityTracker() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public void initializeData() {
        teachers.add(new FullTimeTeacher("John Doe", 50000, 5));
        teachers.add(new FullTimeTeacher("Jane Smith", 55000, 8));
        teachers.add(new PartTimeTeacher("Michael Johnson", 30, 2, 10));
        teachers.add(new PartTimeTeacher("Emily Brown", 25, 3, 8));

        students.add(new Student("Alice", 1, 20));
        students.add(new Student("Bob", 2, 21));
        students.add(new Student("Charlie", 3, 22));
        students.add(new Student("Diana", 4, 23));
        students.add(new Student("Eva", 5, 24));
        students.add(new Student("Frank", 6, 25));

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

    public void printProfessors() {
        System.out.println("Professors:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getClass().getSimpleName() + " - " + teacher.getName());
        }
    }

    public void printClasses() {
        System.out.println("Classes:");
        int i = 1;
        for (Subject subject : subjects) {
            System.out.println(i + ". " + subject.getName());
            i++;
        }
    }

    public void printClassData(int classIndex) {
        if (classIndex >= 0 && classIndex < subjects.size()) {
            Subject subject = subjects.get(classIndex);
            System.out.println("Class: " + subject.getName());
            System.out.println("Teacher: " + subject.getTeacher().getName());
            System.out.println("Students:");
            for (Student student : subject.getStudents()) {
                System.out.println(student.getName());
            }
        }
    }

    public void createNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        Student newStudent = new Student(name, id, age);
        students.add(newStudent);

        System.out.println("Student created and added to the list.");
    }

    public void createNewClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter classroom: ");
        String classroom = scanner.nextLine();

        System.out.println("Teachers:");
        printProfessors();
        System.out.print("Enter teacher index: ");
        int teacherIndex = scanner.nextInt();

        System.out.println("Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". " + students.get(i).getName());
        }
        System.out.print("Enter student indexes (comma-separated): ");
        String studentIndexesInput = scanner.next();
        String[] studentIndexes = studentIndexesInput.split(",");
        List<Student> selectedStudents = new ArrayList<>();
        for (String index : studentIndexes) {
            int studentIndex = Integer.parseInt(index.trim());
            selectedStudents.add(students.get(studentIndex));
        }

        Subject newSubject = new Subject(className, classroom, teachers.get(teacherIndex));
        for (Student student : selectedStudents) {
            newSubject.enrollStudent(student);
        }

        subjects.add(newSubject);

        System.out.println("Class created and added to the list.");
    }

    public void listClassesForStudent(int studentId) {
        System.out.println("Classes for Student with ID " + studentId + ":");
        for (Subject subject : subjects) {
            for (Student student : subject.getStudents()) {
                if (student.getId() == studentId) {
                    System.out.println(subject.getName());
                    break;
                }
            }
        }
    }



}
