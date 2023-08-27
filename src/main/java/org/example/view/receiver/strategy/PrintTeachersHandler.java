package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IStrategyHandler;

public class PrintTeachersHandler implements IStrategyHandler {
    private final IUniversityTracker tracker; // Instancia del rastreador de la universidad.

    public PrintTeachersHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        printTeachers(); // Llama al método para imprimir la lista de profesores.
    }

    private void printTeachers() {
        tracker.printTeachers(); // Utiliza el rastreador de la universidad para imprimir la lista de profesores.
    }
}
