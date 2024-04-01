package com.dev.school.service;

import java.util.List;

import com.dev.school.model.Student;

public interface StudentService {
 public List<Student> getAll();
 public void add(Student student);
 public void update(Student studentParameter);
 public void delete(String id);
 public Student findById(String id);
}
