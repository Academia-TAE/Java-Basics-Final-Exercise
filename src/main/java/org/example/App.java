package org.example;

import org.example.view.IMainMenu;
import org.example.view.receiver.MainMenu;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.runApplication();
    }

    private void runApplication(){
        IMainMenu mainClass = new MainMenu();
        printTitle();
        mainClass.runApplication();
    }

    private void printTitle(){
        System.out.println("\n<FIRST FINAL PROJECT>\nBy: gsusdavid27");
    }
}
