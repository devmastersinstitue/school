package com.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDomain {
    private UUID id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String contactNumber;
    private String grade;
    private String address;
}
