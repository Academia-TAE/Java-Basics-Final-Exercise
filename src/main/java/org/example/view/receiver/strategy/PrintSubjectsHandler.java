package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

public class PrintSubjectsHandler implements IStrategyHandler {
    private final IUniversityTracker tracker; // Instancia del rastreador de la universidad.
    private final IConsole console = new IntegerInput(); // Interfaz para leer entrada del usuario.

    public PrintSubjectsHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        tracker.printSubjects(); // Imprime la lista de asignaturas.
        int subjectIndex = askForIntegerInput(); // Solicita al usuario ingresar el índice de la asignatura.
        tracker.printSubjectData(subjectIndex - 1); // Imprime los datos de la asignatura según el índice.
    }

    private int askForIntegerInput() {
        return console.readInteger("Enter subject index"); // Solicita al usuario ingresar el índice de la asignatura utilizando la interfaz IConsole.
    }
}
