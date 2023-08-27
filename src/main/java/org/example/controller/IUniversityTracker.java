package org.example.controller;

public interface IUniversityTracker {

    void printTeachers();

    void printSubjects();

    void printSubjectData(int i);

    void createNewStudent(String name, int age, int sbj);

    void createNewSubject(String subjectName, String classroom, int teacherIndex, String studentIndexesInput);

    void listSubjectsForStudent(int studentId);

    void printStudents();
}
