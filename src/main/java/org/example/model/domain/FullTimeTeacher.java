package org.example.model.domain;

public class FullTimeTeacher extends Teacher {
    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary, experienceYears);
        super.salary = calculateSalary();
    }

    @Override
    public double calculateSalary() {
        return super.getSalary() * (1 + 0.1 * super.getExperienceYears());
    }

    @Override
    public String toString() {
        return "Full-Time Teacher - Name: " + super.getName() +
                ", Experience Years: " + super.getExperienceYears() +
                ", Total Salary: " + super.getSalary();
    }
}
