package org.example.model.domain;

public class PartTimeTeacher extends Teacher {
    public PartTimeTeacher(String name, double baseSalary, int activeHoursPerWeek) {
        super(name, baseSalary, 0, activeHoursPerWeek, false);
    }
}
