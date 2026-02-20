package com.school.transformer;

import com.school.domain.StudentDomain;
import com.school.model.StudentModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentTransformer extends Transformer<StudentDomain, StudentModel> {
    @Override
    public StudentDomain toEntity(StudentModel model) {
        if(model == null)
            return null;
        return StudentDomain.builder()
                .id(model.getId() == null ? UUID.randomUUID() : model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .firstName(model.getFirstName())
                .grade(model.getGrade())
                .contactNumber(model.getContactNumber())
                .address(model.getAddress())
                .build();

    }

    @Override
    public StudentModel toModel(StudentDomain entity) {
        if(entity == null)
            return null;
        return StudentModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .fatherName(entity.getFatherName())
                .contactNumber(entity.getContactNumber())
                .grade(entity.getGrade())
                .address(entity.getAddress())
                .build();
    }
}
