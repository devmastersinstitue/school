package com.school.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    private UUID id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String contactNumber;
    private String grade;
    private String address;
}
