package org.example.model.domain;

public abstract class Teacher {
    protected String name;
    protected double salary;
    protected int experienceYears;
    public Teacher(String name, double baseSalary, int experienceYears) {
        this.name = name;
        this.salary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getSalary() {
        return this.salary;
    }
    public int getExperienceYears() {
        return this.experienceYears;
    }

    public String getName() {
        return name;
    }
    public abstract double calculateSalary();
    public abstract String toString();
}
