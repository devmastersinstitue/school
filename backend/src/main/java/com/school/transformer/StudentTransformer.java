package com.school.transformer;

import com.school.domain.StudentDomain;
import com.school.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer extends Transformer<StudentDomain, StudentModel> {
    @Override
    public StudentDomain toEntity(StudentModel model) {
        return null;
    }

    @Override
    public StudentModel toModel(StudentDomain entity) {
        return null;
    }
}
