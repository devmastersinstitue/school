package com.school.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherModel {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String department;
    private String designation;
}
