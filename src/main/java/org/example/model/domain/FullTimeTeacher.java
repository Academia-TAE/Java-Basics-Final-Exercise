package org.example.model.domain;

public class FullTimeTeacher extends Teacher {
    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary, experienceYears);
        super.salary = calculateSalary();
    }

    @Override
    public double calculateSalary() {
        return super.getBaseSalary() * (1 + 0.1 * super.getExperienceYears());
    }
}
