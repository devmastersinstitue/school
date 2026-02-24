package com.school.transformer;

import com.school.domain.TeacherDomain;
import com.school.model.TeacherModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TeacherTransformer extends Transformer<TeacherDomain, TeacherModel> {
    @Override
    public TeacherDomain toEntity(TeacherModel model){
        if(model == null)
            return null;
        return TeacherDomain.builder()
                .id(model.getId() == null ? UUID.randomUUID() : model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .email(model.getEmail())
                .department(model.getDepartment())
                .designation(model.getDesignation())
                .build();

    }

    @Override
    public TeacherModel toModel(TeacherDomain entity){
        if(entity == null)
            return null;
        return TeacherModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .department(entity.getDepartment())
                .designation(entity.getDesignation())
                .build();
    }
}
