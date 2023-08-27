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
    // Listas para almacenar información sobre profesores, estudiantes y asignaturas.
    private final List<Teacher> teachers;
    private final List<Student> students;
    private final List<Subject> subjects;

    public UniversityTracker() {
        // Inicialización de las listas a través de un repositorio.
        IRepositoryInitializer repository = new RepositoryInitializer();
        teachers = repository.getStoragedTeachers();
        students = repository.getStoragedStudents();
        subjects = repository.getStoragedSubjects();
    }

    // Implementación del patrón Singleton para obtener una única instancia de UniversityTracker.
    public static IUniversityTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final IUniversityTracker INSTANCE = new UniversityTracker();
    }

    // Método para imprimir la lista de estudiantes.
    @Override
    public void printStudents() {
        students.forEach(student -> System.out.println("    -> " + student));
    }

    // Método para imprimir la lista de profesores.
    @Override
    public void printTeachers() {
        AtomicInteger index = new AtomicInteger(1);
        teachers.forEach(teacher -> System.out.println("[" + index.getAndIncrement() + "] -> " + teacher));
    }

    // Método para imprimir la lista de asignaturas.
    @Override
    public void printSubjects() {
        System.out.println("Subjects:");
        IntStream.range(0, subjects.size())
                .mapToObj(index -> (index + 1) + ". " + subjects.get(index).getName())
                .forEach(System.out::println);
    }

    // Método para imprimir los datos de una asignatura por su índice.
    @Override
    public void printSubjectData(int subjectIndex) {
        Optional<Subject> subject = getSubjectByIndex(subjectIndex);
        subject.ifPresentOrElse(System.out::println, () -> System.out.println("Subject not found."));
    }

    // Método para crear un nuevo estudiante y matricularlo en una asignatura.
    @Override
    public void createNewStudent(String name, int age, int subjectNumber) {
        Student newStudent = new Student(name, age);
        students.add(newStudent);
        enrollStudentInSubject(newStudent, subjectNumber);
        System.out.println("Student created and added to the list.");
    }

    // Método para crear una nueva asignatura y asignarle estudiantes.
    @Override
    public void createNewSubject(String subjectName, String classroom, int teacherIndex, String studentIndexesInput) {
        String[] studentIndexes = studentIndexesInput.split(",");
        List<Integer> selectedIndexes = getSelectedStudentIndexes(studentIndexes);

        if (!validateSelectedIndexes(selectedIndexes)) {
            System.out.println("Subject not created -> Invalid or duplicate student indexes.");
            return;
        }

        try{
            Teacher teacher = getTeacher(teacherIndex);
            Subject newSubject = createSubject(subjectName, classroom, teacher);

            enrollStudents(newSubject, selectedIndexes);

            subjects.add(newSubject);
            System.out.println("Subject created and added to the list.");
        }catch (Exception e){
            System.out.println("Subject not created -> Invalid Teacher.");
        }
    }

    // Método para listar las asignaturas de un estudiante por su ID.
    @Override
    public void listSubjectsForStudent(int studentId) {
        System.out.println("Subjects for Student with ID " + studentId + ":");
        subjects.stream()
                .filter(subject -> subject.getStudents().stream()
                        .anyMatch(student -> student.getId() == studentId))
                .forEach(subject -> System.out.println(subject.getName()));
    }

    // Método para obtener los índices de estudiantes seleccionados.
    private List<Integer> getSelectedStudentIndexes(String[] studentIndexes) {
        return Arrays.stream(studentIndexes)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(index -> index >= 0 && index < students.size())
                .boxed()
                .collect(Collectors.toList());
    }

    // Método para validar los índices de estudiantes seleccionados.
    private boolean validateSelectedIndexes(List<Integer> selectedIndexes) {
        Set<Integer> selectedIndexesSet = new HashSet<>(selectedIndexes);
        return selectedIndexes.size() == selectedIndexesSet.size();
    }

    // Método para obtener un profesor por su índice.
    private Teacher getTeacher(int teacherIndex) {
        return teachers.get(teacherIndex - 1);
    }

    // Método para crear una nueva asignatura.
    private Subject createSubject(String subjectName, String classroom, Teacher teacher) {
        return new Subject(subjectName, classroom, teacher);
    }

    // Método para obtener una asignatura por su índice.
    private Optional<Subject> getSubjectByIndex(int subjectIndex) {
        return subjects.stream()
                .filter(subject -> subjects.indexOf(subject) == subjectIndex)
                .findFirst();
    }

    // Método para matricular estudiantes en una asignatura.
    private void enrollStudents(Subject subject, List<Integer> selectedIndexes) {
        List<Student> selectedStudents = selectedIndexes.stream()
                .map(students::get)
                .toList();

        selectedStudents.forEach(subject::enrollStudent);
    }

    // Método para matricular un estudiante en una asignatura por su número.
    private void enrollStudentInSubject(Student student, int subjectNumber) {
        if (subjectNumber >= 1 && subjectNumber <= subjects.size()) {
            subjects.get(subjectNumber - 1).enrollStudent(student);
        } else {
            System.out.println("Invalid Subject Number. Student not enrolled.");
        }
    }
}
