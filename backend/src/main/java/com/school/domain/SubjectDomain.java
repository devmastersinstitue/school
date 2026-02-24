package com.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Document (collection = "subject")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDomain {
    private UUID id;
    private String name;
    private String code;
    private String credits;
    private String department;

}
