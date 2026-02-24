package com.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDomain {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String department;
    private String designation;

}
