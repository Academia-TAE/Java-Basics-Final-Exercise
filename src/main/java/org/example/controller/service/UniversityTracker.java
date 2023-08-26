package org.example.controller.service;

import org.example.model.domain.Student;
import org.example.model.domain.Subject;
import org.example.model.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class UniversityTracker {
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Subject> classes = new ArrayList<>();
    /*
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new FullTimeTeacher("John Doe", 3000, 5));
        teachers.add(new PartTimeTeacher("Alice Johnson", 25, 15));

        // Initialize students and subjects

        // ... (same code as before)

        // Output teacher information and salaries using polymorphism
        System.out.println("Teacher Information:");
        for (Teacher teacher : teachers) {
            System.out.println("Teacher: " + teacher.getName());
            System.out.println("Salary: $" + teacher.calculateSalary());
        }

        // Output enrolled students in each subject
        // ... (same code as before)
    }
    */

}
