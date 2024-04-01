package com.dev.school.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dev.school.model.Student;

@Repository
public class StudentRepositoryImpl{
    private ArrayList<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public void update(Student studentParameter) {
        students.forEach(student -> {
            if (studentParameter.getRegistrationNumber().equals(student.getRegistrationNumber())) {
                student.setFirstName(studentParameter.getFirstName());
                student.setLastName(studentParameter.getLastName());
            }
        });
    }

    public void delete(String id) {
        students.removeIf(student -> id.equals(student.getRegistrationNumber()));
    }

    public Optional<Student> findById(String id) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> id.equals(student.getRegistrationNumber()))
                .findFirst();
        return studentOptional;
    }

}
