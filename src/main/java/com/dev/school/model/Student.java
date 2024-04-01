package com.dev.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//in case vscode display error on lombok remove this java support language extension => georgewfraser.vscode-javac 
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "registrationNumber")
    private String registrationNumber;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
}
