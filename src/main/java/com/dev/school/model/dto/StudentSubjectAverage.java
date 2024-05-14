package com.dev.school.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectAverage {
    private String firstName;
    private String lastName;
    private String subjectName;
    private double average;
}
