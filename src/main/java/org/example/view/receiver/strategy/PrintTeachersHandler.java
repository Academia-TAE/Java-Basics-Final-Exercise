package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IStrategyHandler;

public class PrintTeachersHandler implements IStrategyHandler {
    private final IUniversityTracker tracker;

    public PrintTeachersHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        printTeachers();
    }

    private void printTeachers() {
        tracker.printTeachers();
    }
}
