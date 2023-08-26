package org.example.model.domain;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek;
    public PartTimeTeacher(String name, double baseSalary, int experienceYears, int hoursPerWeek) {
        super(name, baseSalary, experienceYears);
        this.activeHoursPerWeek=hoursPerWeek;
        super.salary = calculateSalary();
    }
    @Override
    public double calculateSalary() {
        return super.getBaseSalary() * this.activeHoursPerWeek;
    }
}
