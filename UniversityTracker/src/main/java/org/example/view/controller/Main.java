package org.example.view.controller;

import org.example.controller.IUniversityTracker;
import org.example.controller.service.UniversityTracker;
import org.example.view.IMain;

import java.util.Scanner;

public class Main implements IMain {
    IUniversityTracker tracker = new UniversityTracker();
    public void runApplication() {
        tracker.initializeData();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes");
            System.out.println("3. Print class data");
            System.out.println("4. Create a new student and add to class");
            System.out.println("5. Create a new class");
            System.out.println("6. List classes for a student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tracker.printProfessors();
                    break;
                case 2:
                    tracker.printClasses();
                    break;
                case 3:
                    System.out.print("Enter class index: ");
                    int classIndex = scanner.nextInt();
                    tracker.printClassData(classIndex - 1);
                    break;
                case 4:
                    tracker.createNewStudent();
                    break;
                case 5:
                    tracker.createNewClass();
                    break;
                case 6:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    tracker.listClassesForStudent(studentId);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
