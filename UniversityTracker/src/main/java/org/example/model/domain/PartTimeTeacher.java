package org.example.model.domain;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek;
    public PartTimeTeacher(String name, double baseSalary, int experienceYears, int hoursPerWeek) {
        super(name, baseSalary, experienceYears);
        this.activeHoursPerWeek=hoursPerWeek;
    }
    public double calculateSalary() {
        return super.getBaseSalary() * this.getActiveHoursPerWeek();
    }
    public int getActiveHoursPerWeek() {
        return this.activeHoursPerWeek;
    }
}
