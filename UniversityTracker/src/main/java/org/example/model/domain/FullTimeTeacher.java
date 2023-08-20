package org.example.model.domain;

public class FullTimeTeacher extends Teacher {
    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary, experienceYears, 0, true);
    }
}
