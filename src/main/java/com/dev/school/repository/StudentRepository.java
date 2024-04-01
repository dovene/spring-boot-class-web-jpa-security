package com.dev.school.repository;

import java.util.List;
import java.util.Optional;

import com.dev.school.model.Student;

public interface StudentRepository {
 public List<Student> getAll();
 public void add(Student student);
 public void update(Student studentParameter);
 public void delete(String id);
 public Optional<Student> findById(String id);
}
