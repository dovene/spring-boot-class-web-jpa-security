package com.dev.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
 
}
