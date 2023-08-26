package org.example;

import org.example.view.IMain;
import org.example.view.controller.Main;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.runApplication();
    }

    private void runApplication(){
        IMain mainClass = new Main();
        printTitle();
        mainClass.runApplication();
    }

    private void printTitle(){
        System.out.println("\n<FIRST FINAL PROJECT>\nBy: gsusdavid27");
    }
}
