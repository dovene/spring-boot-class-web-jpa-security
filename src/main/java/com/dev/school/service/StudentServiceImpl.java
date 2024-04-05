package com.dev.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Student;
import com.dev.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void update(Student studentParameter) {
        if (findById(studentParameter.getRegistrationNumber()) != null){
            studentRepository.save(studentParameter);
        }
    }

    public void delete(String id) {
        if (findById(id) != null){
            studentRepository.deleteById(id);
        }
    }

    public Student findById(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

}
