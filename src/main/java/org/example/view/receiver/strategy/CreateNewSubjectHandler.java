package org.example.view.receiver.strategy;

import org.example.controller.IUniversityTracker;
import org.example.view.receiver.IConsole;
import org.example.view.receiver.IStrategyHandler;
import org.example.view.receiver.input.IntegerInput;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateNewSubjectHandler implements IStrategyHandler {
    private final IUniversityTracker tracker; // Instancia del rastreador de la universidad.
    private final IConsole console = new IntegerInput(); // Interfaz para leer entrada del usuario.
    private final Scanner scanner; // Escáner para entrada de texto.

    public CreateNewSubjectHandler(IUniversityTracker tracker) {
        this.tracker = tracker;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void useStrategy() {
        String subjectName = enterInfo("subject name"); // Solicita el nombre de la asignatura.
        String classroom = enterInfo("classroom"); // Solicita el aula de la asignatura.
        int teacherIndex = selectTeacherIndex(); // Selecciona el índice del profesor.
        String studentIndexesInput = enterStudentIndexesInput(); // Solicita los índices de estudiantes.

        tracker.createNewSubject(subjectName, classroom, teacherIndex, studentIndexesInput); // Crea una nueva asignatura.
    }

    private String enterInfo(String infoType) {
        System.out.print("Enter " + infoType + ": "); // Solicita al usuario ingresar cierta información.
        return scanner.nextLine(); // Lee y retorna la entrada del usuario.
    }

    private int selectTeacherIndex() {
        System.out.println("Teachers:");
        tracker.printTeachers(); // Imprime la lista de profesores.
        return askForIntegerInput("Enter teacher index"); // Solicita al usuario ingresar el índice del profesor.
    }

    private String enterStudentIndexesInput() {
        while (true) {
            System.out.println("Students:");
            tracker.printStudents(); // Imprime la lista de estudiantes.
            System.out.print("Enter student IDs (comma-separated): "); // Solicita los índices de estudiantes.

            String input = scanner.nextLine().trim();

            if (input.isEmpty() || !isValidInput(input)) {
                System.out.println("Error: Invalid input. Please enter only numeric values separated by commas.");
                continue;
            }

            return input; // Retorna los índices de estudiantes ingresados por el usuario.
        }
    }

    private boolean isValidInput(String input) {
        String[] tokens = input.split(",");
        return IntStream.range(0, tokens.length)
                .allMatch(i -> tokens[i].matches("\\d+")); // Verifica si todos los tokens son valores numéricos.
    }

    private int askForIntegerInput(String prompt) {
        return console.readInteger(prompt); // Solicita al usuario ingresar un valor entero utilizando la interfaz IConsole.
    }
}
