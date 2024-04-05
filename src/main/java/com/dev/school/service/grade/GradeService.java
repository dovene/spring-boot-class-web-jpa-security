package com.dev.school.service.grade;

import java.util.List;

import com.dev.school.model.Grade;


public interface GradeService {
 public List<Grade> getAll();
 public void add(Grade grade);
 public void update(Grade gradeParameter);
 public void delete(Long id);
 public Grade findById(Long id);
}
