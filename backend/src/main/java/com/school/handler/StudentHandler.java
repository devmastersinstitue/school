package com.school.handler;

import com.school.domain.StudentDomain;
import com.school.model.StudentModel;
import com.school.service.StudentService;
import com.school.transformer.StudentTransformer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentHandler {
    private final StudentTransformer studentTransformer;
    private final StudentService studentService;

    public StudentModel create(StudentModel model) {
        StudentDomain studentDomain = studentTransformer.toEntity(model);
        studentService.create(studentDomain);
        return studentTransformer.toModel(studentDomain);
    }
}
