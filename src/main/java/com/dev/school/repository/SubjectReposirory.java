package com.dev.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.school.model.Subject;

public interface SubjectReposirory extends JpaRepository<Subject, Long> {
    
}
