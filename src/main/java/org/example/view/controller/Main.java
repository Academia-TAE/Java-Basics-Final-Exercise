package org.example.view.controller;

import org.example.view.IMain;

import java.util.Scanner;

public class Main implements IMain {
    public void runApplication() {

        Scanner scanner = new Scanner(System.in);


        // Inicialización de profesores, estudiantes y clases (según el enunciado)

        boolean exit = false;
        while (!exit) {
            System.out.println("Menú:");
            System.out.println("a. Imprimir todos los profesores con sus datos");
            System.out.println("b. Imprimir todas las clases");
            System.out.println("c. Crear un nuevo estudiante y agregarlo a una clase existente");
            System.out.println("d. Crear una nueva clase");
            System.out.println("e. Listar todas las clases en las que está incluido un estudiante");
            System.out.println("f. Salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "a":
                    // Imprimir todos los profesores
                    // Código aquí
                    break;
                case "b":
                    // Imprimir todas las clases y submenu
                    // Código aquí
                    break;
                case "c":
                    // Crear un nuevo estudiante y agregarlo a una clase existente
                    // Código aquí
                    break;
                case "d":
                    // Crear una nueva clase
                    // Código aquí
                    break;
                case "e":
                    // Listar todas las clases en las que está incluido un estudiante
                    // Código aquí
                    break;
                case "f":
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }


        }

    }
}
