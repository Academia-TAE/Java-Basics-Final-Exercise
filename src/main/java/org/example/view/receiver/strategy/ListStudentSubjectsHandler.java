package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

public class ListStudentSubjectsHandler implements IStrategyHandler {
    private final IUniversityTracker tracker; // Instancia del rastreador de la universidad.
    private final IConsole console = new IntegerInput(); // Interfaz para leer entrada del usuario.

    public ListStudentSubjectsHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void useStrategy() {
        tracker.printStudents(); // Imprime la lista de estudiantes.
        int studentId = askForIntegerInput(); // Solicita al usuario ingresar el ID del estudiante.
        tracker.listSubjectsForStudent(studentId); // Lista las asignaturas para el estudiante dado.
    }

    private int askForIntegerInput() {
        return console.readInteger("Enter student ID"); // Solicita al usuario ingresar el ID del estudiante utilizando la interfaz IConsole.
    }
}
