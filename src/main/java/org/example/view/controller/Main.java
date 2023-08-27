package org.example.view.controller;

import org.example.controller.IUniversityTracker;
import org.example.controller.service.UniversityTracker;
import org.example.view.IMain;

import java.util.Scanner;

public class Main implements IMain {
    private final IUniversityTracker tracker;
    private final Scanner scanner = new Scanner(System.in);

    public Main() {
        tracker = new UniversityTracker();
    }

    @Override
    public void runApplication() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    tracker.printTeachers();
                    break;
                case 2:
                    handlePrintClassesWithDetails();
                    break;
                case 3:
                    handleCreateNewStudent();
                    break;
                case 4:
                    handleCreateNewClass();
                    break;
                case 5:
                    handleListClassesForStudent();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n---Menu:");
        System.out.println("1. Print all professors");
        System.out.println("2. Print all classes and their data");
        System.out.println("3. Create a new student and add to a class");
        System.out.println("4. Create a new class");
        System.out.println("5. List classes for a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void handlePrintClassesWithDetails() {
        tracker.printClasses();
        System.out.print("Enter class index: ");
        int classIndex = getUserChoice();
        tracker.printClassData(classIndex - 1);
    }

    private void handleListClassesForStudent() {
        System.out.print("Enter student ID: ");
        int studentId = getUserChoice();
        tracker.listClassesForStudent(studentId);
    }

    private String askForName(String entity) {
        System.out.print("Enter " + entity + " name: ");
        return scanner.nextLine();
    }

    private int askForAge() {
        while (true) {
            System.out.print("Enter age: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private int askForNumber(String entity) {
        tracker.printClasses();
        while (true) {
            System.out.print("Enter " + entity + " Subject number: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private void handleCreateNewStudent() {
        scanner.nextLine();
        String name = askForName("student");
        int age = askForAge();
        int number = askForNumber("student");

        tracker.createNewStudent(name, age, number);
    }


    private void handleCreateNewClass() {
        scanner.nextLine();
        tracker.createNewClass(
                enterInfo("class name"),
                enterInfo("classroom"),
                selectTeacherIndex(),
                enterStudentIndexesInput()
        );
    }

    private String enterInfo(String infoType) {
        System.out.print("Enter " + infoType + ": ");
        return scanner.nextLine();
    }

    private int selectTeacherIndex() {
        System.out.println("Teachers:");
        tracker.printTeachers();
        System.out.print("Enter teacher index: ");
        return getUserChoice();
    }

    private String enterStudentIndexesInput() {
        scanner.nextLine();
        System.out.println("Students:");
        tracker.printStudents();
        System.out.print("Enter student IDs (comma-separated): ");
        return scanner.nextLine();
    }
}
