package org.example.model;

import org.example.model.domain.Student;
import org.example.model.domain.Subject;
import org.example.model.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface IRepositoryInitializer {
    public List<Teacher> getStoragedTeachers();
    public List<Student> getStoragedStudents();
    public List<Subject> getStoragedSubjects();
}
