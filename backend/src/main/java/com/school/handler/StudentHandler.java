package com.school.handler;

import com.school.domain.StudentDomain;
import com.school.model.StudentModel;
import com.school.service.StudentService;
import com.school.transformer.StudentTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentHandler {
    private StudentTransformer studentTransformer;
    private StudentService studentService;

    public StudentModel create(StudentModel model) {
        StudentDomain studentDomain = studentTransformer.toEntity(model);
        studentService.create(studentDomain);
        return studentTransformer.toModel(studentDomain);
    }
}
