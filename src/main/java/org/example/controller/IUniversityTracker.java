package org.example.controller;

public interface IUniversityTracker {

    void printTeachers();

    void printClasses();

    void printClassData(int i);

    void createNewStudent();

    void createNewClass();

    void listClassesForStudent(int studentId);
}
