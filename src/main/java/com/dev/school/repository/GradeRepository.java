package com.dev.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.school.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    
    @Query("SELECT g.student, g.subject, AVG(g.gradeValue) " +
           "FROM Grade g " +
           "GROUP BY g.student, g.subject")
    List<Object[]> calculateStudentSubjectAverages();
}
