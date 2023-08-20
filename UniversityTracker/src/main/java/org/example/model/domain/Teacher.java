package org.example.model.domain;

public class Teacher {
    protected String name;
    protected double baseSalary;
    protected int experienceYears;
    public Teacher(String name, double baseSalary, int experienceYears) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return this.baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
}
