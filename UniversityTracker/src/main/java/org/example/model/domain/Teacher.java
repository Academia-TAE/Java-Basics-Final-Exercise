package org.example.model.domain;

public abstract class Teacher {
    protected String name;
    protected double baseSalary;
    protected int experienceYears;
    protected int activeHoursPerWeek;
    protected boolean isFullTime;

    public Teacher(String name, double baseSalary, int experienceYears, int activeHoursPerWeek, boolean isFullTime) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
        this.activeHoursPerWeek = activeHoursPerWeek;
        this.isFullTime = isFullTime;
    }

    public double calculateSalary() {
        if (isFullTime) {
            return baseSalary * (1 + 0.1 * experienceYears);
        } else {
            return baseSalary * activeHoursPerWeek;
        }
    }

    public String getName() {
        return name;
    }
}
