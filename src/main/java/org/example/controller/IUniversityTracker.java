package org.example.controller;

import org.example.model.domain.Student;

import java.util.List;

public interface IUniversityTracker {

    void printTeachers();

    void printClasses();

    void printClassData(int i);

    void createNewStudent(String name, int age, int sbj);

    void createNewClass(String className, String classroom, int teacherIndex, String studentIndexesInput);

    void listClassesForStudent(int studentId);

    void printStudents();
}
