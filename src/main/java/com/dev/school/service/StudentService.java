package com.dev.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Student;
import com.dev.school.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public void add(Student student) {
        studentRepository.add(student);
    }

    public void update(Student studentParameter) {
        studentRepository.update(studentParameter);
    }

    public void delete(String id) {
        studentRepository.delete(id);
    }

    public Student findById(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

}
