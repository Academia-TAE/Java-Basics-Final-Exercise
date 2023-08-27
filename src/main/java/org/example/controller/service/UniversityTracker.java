package org.example.controller.service;

import org.example.controller.IUniversityTracker;
import org.example.model.IRepositoryInitializer;
import org.example.model.domain.*;
import org.example.model.repository.RepositoryInitializer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniversityTracker implements IUniversityTracker {
    private final List<Teacher> teachers;
    private final List<Student> students;
    private final List<Subject> subjects;

    public UniversityTracker() {
        IRepositoryInitializer repository = new RepositoryInitializer();
        teachers = repository.getStoragedTeachers();
        students = repository.getStoragedStudents();
        subjects = repository.getStoragedSubjects();
    }

    public static IUniversityTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final IUniversityTracker INSTANCE = new UniversityTracker();
    }

    @Override
    public void printStudents() {
        students.forEach(student -> System.out.println("    -> " + student));
    }
    @Override
    public void printTeachers() {
        AtomicInteger index = new AtomicInteger(1);
        teachers.forEach(teacher -> System.out.println("[" + index.getAndIncrement() + "] -> " + teacher));
    }

    @Override
    public void printClasses() {
        System.out.println("Classes:");
        IntStream.range(0, subjects.size())
                .mapToObj(index -> (index + 1) + ". " + subjects.get(index).getName())
                .forEach(System.out::println);
    }

    @Override
    public void printClassData(int classIndex) {
        subjects.stream()
                .filter(subject -> subjects.indexOf(subject) == classIndex)
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Override
    public void createNewStudent(String name, int age, int subjectNumber) {
        Student newStudent = new Student(name, age);
        students.add(newStudent);
        enrollStudentInSubject(newStudent, subjectNumber);
        System.out.println("Student created and added to the list.");
    }

    @Override
    public void createNewClass(String className, String classroom, int teacherIndex, String studentIndexesInput) {
        String[] studentIndexes = studentIndexesInput.split(",");

        List<Integer> selectedIndexes = getSelectedStudentIndexes(studentIndexes);

        if (!validateSelectedIndexes(selectedIndexes)) {
            System.out.println("Subject not created->Invalid or duplicate student indexes.");
            return;
        }

        Teacher teacher = getTeacher(teacherIndex);
        Subject newSubject = createSubject(className, classroom, teacher);

        enrollStudents(newSubject, selectedIndexes);

        subjects.add(newSubject);
        System.out.println("Class created and added to the list.");
    }

    private List<Integer> getSelectedStudentIndexes(String[] studentIndexes) {
        return Arrays.stream(studentIndexes)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(index -> index >= 0 && index < students.size())
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean validateSelectedIndexes(List<Integer> selectedIndexes) {
        Set<Integer> selectedIndexesSet = new HashSet<>(selectedIndexes);
        return selectedIndexes.size() == selectedIndexesSet.size();
    }

    private Teacher getTeacher(int teacherIndex) {
        return teachers.get(teacherIndex - 1);
    }

    private Subject createSubject(String className, String classroom, Teacher teacher) {
        return new Subject(className, classroom, teacher);
    }

    @Override
    public void listClassesForStudent(int studentId) {
        System.out.println("Classes for Student with ID " + studentId + ":");
        subjects.stream()
                .filter(subject -> subject.getStudents().stream()
                        .anyMatch(student -> student.getId() == studentId))
                .forEach(subject -> System.out.println(subject.getName()));
    }

    private void enrollStudents(Subject subject, List<Integer> selectedIndexes) {
        List<Student> selectedStudents = selectedIndexes.stream()
                .map(students::get)
                .collect(Collectors.toList());

        selectedStudents.forEach(subject::enrollStudent);
    }

    private void enrollStudentInSubject(Student student, int subjectNumber) {
        if (subjectNumber >= 1 && subjectNumber <= subjects.size()) {
            subjects.get(subjectNumber - 1).enrollStudent(student);
        } else {
            System.out.println("Invalid Subject Number. Student not enrolled.");
        }
    }
}