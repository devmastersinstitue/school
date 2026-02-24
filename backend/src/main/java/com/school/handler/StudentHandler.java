package com.school.handler;

import com.school.domain.StudentDomain;
import com.school.model.StudentModel;
import com.school.service.StudentService;
import com.school.transformer.StudentTransformer;
import com.school.transformer.Transformer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentHandler {
    private final StudentTransformer studentTransformer;
    private final StudentService studentService;

    /*@Autowired
    public StudentHandler(StudentService studentService, StudentTransformer studentTransformer) {
        this.studentService = studentService;
        this.studentTransformer = studentTransformer;
    }*/

    public StudentModel create(StudentModel model) {
        StudentDomain studentDomain = studentTransformer.toEntity(model);
        studentService.create(studentDomain);
        return studentTransformer.toModel(studentDomain);
    }

    public List<StudentModel> getAll() {
        List<StudentDomain> studentDomain = studentService.getAll();
        return studentTransformer.toModels(studentDomain);
    }
}
