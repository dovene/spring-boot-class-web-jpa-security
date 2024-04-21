package com.dev.school.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.school.model.Student;
import com.dev.school.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService = new StudentServiceImpl();
    @Test
    void testAdd() {
        // Given
        Student student = new Student();
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        // When
        studentService.add(student);
        // Then
        verify(studentRepository, times(1)).save(student);
    }
    @Test
    void testGetAll() {
        // Given
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setRegistrationNumber("M001");
        students.add(student);
        when(studentRepository.findAll()).thenReturn(students);
        // When
        List<Student> studentsResult = studentService.getAll();
        // Then
        verify(studentRepository, times(1)).findAll();
        assertTrue(studentsResult.get(0).getRegistrationNumber().equals(student.getRegistrationNumber()));
    }
    @Test
    void testDelete() {
        Student student = new Student();
        student.setRegistrationNumber("M001");
        when(studentRepository.findById(student.getRegistrationNumber())).thenReturn(Optional.of(student));
        studentService.delete(student.getRegistrationNumber());
        verify(studentRepository, times(1)).findById(student.getRegistrationNumber());
        verify(studentRepository, times(1)).deleteById(student.getRegistrationNumber());
    }
    @Test
    void testFindById() {
        // Given
        Student student = new Student();
        student.setRegistrationNumber("M001");
        when(studentRepository.findById(student.getRegistrationNumber())).thenReturn(Optional.of(student));
        // When
        studentService.findById(student.getRegistrationNumber());
        // Then
        verify(studentRepository, times(1)).findById(student.getRegistrationNumber());
    }
    @Test
    void testUpdate() {
        // Given
        Student student = new Student();
        student.setRegistrationNumber("M001");
        when(studentRepository.findById(student.getRegistrationNumber())).thenReturn(Optional.of(student));
        // When
        studentService.update(student);
        // Then
        verify(studentRepository, times(1)).findById(student.getRegistrationNumber());
        verify(studentRepository, times(1)).save(student);

    }
}
