package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;


public class ListStudentClassesHandler implements IStrategyHandler {
    private final IUniversityTracker tracker;
    private final IConsole console = new IntegerInput();

    public ListStudentClassesHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        tracker.printStudents();
        int studentId = askForIntegerInput();
        tracker.listClassesForStudent(studentId);
    }

    private int askForIntegerInput() {
        return console.readInteger("Enter student ID");
    }
}
