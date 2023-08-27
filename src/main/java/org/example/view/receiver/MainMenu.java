package org.example.view.receiver;

import org.example.controller.IUniversityTracker;
import org.example.controller.service.UniversityTracker;
import org.example.view.IMainMenu;
import org.example.view.receiver.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu implements IMainMenu {
    // Creación de una instancia del rastreador de universidad y un escáner para entrada de usuario.
    IUniversityTracker tracker = UniversityTracker.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    // Mapa que relaciona las opciones del menú con sus respectivos manejadores de estrategia.
    private final Map<Integer, IStrategyHandler> strategyHandlerMap = new HashMap<>();

    public MainMenu() {
        initializeHandlers(); // Inicialización de los manejadores de estrategia.
    }

    private void initializeHandlers() {
        // Asociación de opciones del menú con manejadores de estrategia específicos.
        strategyHandlerMap.put(1, new PrintTeachersHandler(tracker));
        strategyHandlerMap.put(2, new PrintSubjectsHandler(tracker));
        strategyHandlerMap.put(3, new CreateNewStudentHandler(tracker));
        strategyHandlerMap.put(4, new CreateNewSubjectHandler(tracker));
        strategyHandlerMap.put(5, new ListStudentSubjectsHandler(tracker));
    }

    @Override
    public void runApplication() {
        boolean exit = false;
        while (!exit) {
            printMenu(); // Mostrar el menú en pantalla.
            int choice = getUserChoice(); // Obtener la elección del usuario.
            if (choice != 6 ) { // Si la elección no es salir...
                IStrategyHandler strategy = strategyHandlerMap.get(choice);
                if (strategy != null) {
                    strategy.useStrategy(); // Ejecutar la estrategia asociada con la elección del usuario.
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            } else { // Si la elección es salir...
                exit = true;
                System.out.println("Exiting...");
            }
        }
    }

    private void printMenu() {
        // Mostrar el menú en pantalla para que el usuario elija una opción.
        System.out.println("\n---Menu:");
        System.out.println("1. Print all professors");
        System.out.println("2. Print all subjects and their data");
        System.out.println("3. Create a new student and add to a subject");
        System.out.println("4. Create a new subject");
        System.out.println("5. List subjects for a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        try{
            return scanner.nextInt();
        }catch (Exception e){
            scanner.next();
            return 0;
        }
        // Obtener la elección del usuario desde el escáner.
    }
}
