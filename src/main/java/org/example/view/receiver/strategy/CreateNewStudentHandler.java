package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

import java.util.Scanner;

public class CreateNewStudentHandler implements IStrategyHandler {
    private final IUniversityTracker tracker; // Instancia del rastreador de la universidad.
    private final IConsole console = new IntegerInput(); // Interfaz para leer entrada del usuario.
    private final Scanner scanner; // Escáner para entrada de texto.

    public CreateNewStudentHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void useStrategy() {
        String name = askForInput(); // Solicita el nombre del estudiante.
        int age = askForIntegerInput("age"); // Solicita la edad del estudiante.
        int number = askForIntegerInput("student subject number"); // Solicita el número de asignatura del estudiante.
        tracker.createNewStudent(name, age, number); // Crea un nuevo estudiante y lo agrega a una asignatura.
    }

    private String askForInput() {
        System.out.print("Enter student name: "); // Solicita al usuario ingresar el nombre del estudiante.
        return scanner.nextLine(); // Lee y retorna la entrada del usuario.
    }

    private int askForIntegerInput(String prompt) {
        return console.readInteger(prompt); // Solicita al usuario un valor entero específico utilizando la interfaz IConsole.
    }
}
