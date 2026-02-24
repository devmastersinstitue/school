package com.school.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "grade")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeDomain {
    private UUID id;
    private String className;
    private String classSection;
    private String classTeacherId;
    private String roomNumber;
    private String capacity;
}
