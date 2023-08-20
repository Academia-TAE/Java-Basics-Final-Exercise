package org.example;

import org.example.view.IMain;
import org.example.view.controller.Main;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.printTitle();
        app.runApplication();
    }
    private void printTitle(){
        System.out.println("<FIRST FINAL PROJECT>\nBy: gsusdavid27");
    }
    private void runApplication(){
        IMain mainClass = new Main();
        mainClass.runApplication();
    }
}