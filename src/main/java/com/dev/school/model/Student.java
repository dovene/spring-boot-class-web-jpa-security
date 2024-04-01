package com.dev.school.model;

import lombok.Data;

//in case vscode display error on lombok remove this java support language extension => georgewfraser.vscode-javac 
@Data
public class Student {
    private String registrationNumber;
    private String firstName;
    private String lastName;
}
