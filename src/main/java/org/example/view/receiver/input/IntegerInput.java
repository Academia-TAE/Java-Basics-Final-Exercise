package org.example.view.receiver.input;

import org.example.view.receiver.IConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerInput implements IConsole {
    private final Scanner scanner= new Scanner(System.in);

    @Override
    public int readInteger(String prompt) {
        while (true) {
            try {
                System.out.print("Enter " + prompt + ": ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
