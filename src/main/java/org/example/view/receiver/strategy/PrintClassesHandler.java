package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

import java.util.Scanner;

public class PrintClassesHandler implements IStrategyHandler {
    private final IUniversityTracker tracker;
    private final IConsole console = new IntegerInput();

    public PrintClassesHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        tracker.printClasses();
        int classIndex = askForIntegerInput("Enter class index");
        tracker.printClassData(classIndex - 1);
    }

    private int askForIntegerInput(String prompt) {
        return console.readInteger(prompt);
    }
}
