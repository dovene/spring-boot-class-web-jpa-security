package com.dev.school.service.subject;

import java.util.List;
import com.dev.school.model.Subject;

public interface SubjectService {
 public List<Subject> getAll();
 public void add(Subject subject);
 public void update(Subject subjectParameter);
 public void delete(Long id);
 public Subject findById(Long id);
}
