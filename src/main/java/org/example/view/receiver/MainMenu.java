package org.example.view.receiver;

import org.example.controller.IUniversityTracker;
import org.example.controller.service.UniversityTracker;
import org.example.view.IMainMenu;
import org.example.view.receiver.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu implements IMainMenu {
    IUniversityTracker tracker = UniversityTracker.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, IStrategyHandler> strategyHandlerMap = new HashMap<>();

    public MainMenu() {
        initializeHandlers();
    }

    private void initializeHandlers() {
        strategyHandlerMap.put(1, new PrintTeachersHandler(tracker));
        strategyHandlerMap.put(2, new PrintClassesHandler(tracker));
        strategyHandlerMap.put(3, new CreateNewStudentHandler(tracker));
        strategyHandlerMap.put(4, new CreateNewClassHandler(tracker));
        strategyHandlerMap.put(5, new ListStudentClassesHandler(tracker));
    }

    @Override
    public void runApplication() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getUserChoice();
            if(choice!=6){
                IStrategyHandler strategy = strategyHandlerMap.get(choice);
                if (strategy != null) {
                    strategy.useStrategy();
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            }else{
                exit = true;
                System.out.println("Exiting...");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n---Menu:");
        System.out.println("1. Print all professors");
        System.out.println("2. Print all classes and their data");
        System.out.println("3. Create a new student and add to a class");
        System.out.println("4. Create a new class");
        System.out.println("5. List classes for a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }
}