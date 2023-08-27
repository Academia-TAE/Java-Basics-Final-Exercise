package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

import java.util.Scanner;

public class CreateNewStudentHandler implements IStrategyHandler {
    private final IUniversityTracker tracker;
    private final IConsole console = new IntegerInput();
    private final Scanner scanner;

    public CreateNewStudentHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void useStrategy() {
        String name = askForInput();
        int age = askForIntegerInput("age");
        int number = askForIntegerInput("student subject number");
        tracker.createNewStudent(name, age, number);
    }

    private String askForInput() {
        System.out.print("Enter " + "student name" + ": ");
        return scanner.nextLine();
    }

    private int askForIntegerInput(String prompt) {
        return console.readInteger(prompt);
    }
}
