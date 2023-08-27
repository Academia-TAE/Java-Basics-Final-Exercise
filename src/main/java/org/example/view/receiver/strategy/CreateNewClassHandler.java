package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

import java.util.Scanner;

public class CreateNewClassHandler implements IStrategyHandler {
    private final IUniversityTracker tracker;
    private final IConsole console = new IntegerInput();
    private final Scanner scanner;

    public CreateNewClassHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void useStrategy() {
        String className = enterInfo("class name");
        String classroom = enterInfo("classroom");
        int teacherIndex = selectTeacherIndex();
        String studentIndexesInput = enterStudentIndexesInput();

        tracker.createNewClass(className, classroom, teacherIndex, studentIndexesInput);
    }

    private String enterInfo(String infoType) {
        System.out.print("Enter " + infoType + ": ");
        return scanner.nextLine();
    }

    private int selectTeacherIndex() {
        System.out.println("Teachers:");
        tracker.printTeachers();
        return askForIntegerInput();
    }

    private String enterStudentIndexesInput() {
        while (true) {
            System.out.println("Students:");
            tracker.printStudents();
            System.out.print("Enter student IDs (comma-separated): ");

            String input = scanner.nextLine().trim(); // Leer la entrada y eliminar espacios en blanco

            if (input.isEmpty()) {
                System.out.println("Error: Please enter student IDs.");
                continue; // Volver al inicio del bucle
            }

            String[] tokens = input.split(",");
            boolean validInput = true;

            for (String token : tokens) {
                if (!token.matches("\\d+")) { // Verificar si el token es un número
                    validInput = false;
                    break; // Salir del bucle si se encuentra un token no válido
                }
            }

            if (!validInput) {
                System.out.println("Error: Invalid input. Please enter only numeric values separated by commas.");
                continue; // Volver al inicio del bucle
            }

            return input; // Devolver la entrada si todo es válido
        }
    }

    private int askForIntegerInput() {
        return console.readInteger("Enter teacher index");
    }
}
