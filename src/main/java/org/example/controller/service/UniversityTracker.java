package org.example.controller.service;

import org.example.controller.IUniversityTracker;
import org.example.model.IRepositoryInitializer;
import org.example.model.domain.*;
import org.example.model.repository.RepositoryInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UniversityTracker implements IUniversityTracker {
    private IRepositoryInitializer repository;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Subject> subjects;

    public UniversityTracker() {
        repository= new RepositoryInitializer();
        teachers = repository.getStoragedTeachers();
        students = repository.getStoragedStudents();
        subjects = repository.getStoragedSubjects();
    }

    public void printTeachers() {
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("    -> " + teacher);
        }
    }

    public void printClasses() {
        System.out.println("Classes:");
        for (Subject subject : subjects) {
            int index = subjects.indexOf(subject) + 1;
            System.out.println(index + ". " + subject.getName());
        }
    }


    public void printClassData(int classIndex) {
        if (classIndex >= 0 && classIndex < subjects.size()) {
            Subject subject = subjects.get(classIndex);
            System.out.println(subject);
        }
    }

    /**
     * TODO: Agregar estudiante a una clase, no solo a la lista de students
     * Hacer una especie de singleton con un final static para IDs de students.
     */
    public void createNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        Student newStudent = new Student(name, age);
        students.add(newStudent);

        System.out.print("Enter Subject Number to Enroll the Student: ");
        int subjectNumber = scanner.nextInt();

        for(Subject sbj: subjects){
            if(subjects.indexOf(sbj)==subjectNumber-1){
                sbj.enrollStudent(newStudent);
            }
        }

        System.out.println("Student created and added to the list.");
    }

    /**
     * TODO: supermejoramiento de la clase
     */
    public void createNewClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter classroom: ");
        String classroom = scanner.nextLine();

        System.out.println("Teachers:");
        this.printTeachers();
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

        Subject newSubject = new Subject(className, classroom, teachers.get(teacherIndex-1));
        for (Student student : selectedStudents) {
            newSubject.enrollStudent(student);
        }

        subjects.add(newSubject);

        System.out.println("Class created and added to the list.");
    }

    public void listClassesForStudent(int studentId) {
        System.out.println("Classes for Student with ID " + studentId + ":");
        subjects.stream()
                .filter(subject -> subject.getStudents().stream()
                        .anyMatch(student -> student.getId() == studentId))
                .forEach(subject -> System.out.println(subject.getName()));
    }
}
