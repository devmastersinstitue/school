package com.school.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeModel {
    private UUID id;
    private String className;
    private String classSection;
    private String classTeacherId;
    private String roomNumber;
    private String capacity;
}
