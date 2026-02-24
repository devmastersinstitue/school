package com.school.transformer;

import com.school.domain.SubjectDomain;
import com.school.model.SubjectModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubjectTransformer extends Transformer<SubjectDomain, SubjectModel> {
    @Override
    public SubjectDomain toEntity(SubjectModel model) {
        if(model == null)
            return null;
        return SubjectDomain.builder()
                .id(model.getId() == null ? UUID.randomUUID() : model.getId())
                .name(model.getName())
                .code(model.getCode())
                .credits(model.getCredits())
                .department(model.getDepartment())
                .build();

    }

    @Override
    public SubjectModel toModel(SubjectDomain entity) {
        if(entity == null)
            return null;
        return SubjectModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .credits(entity.getCredits())
                .department(entity.getDepartment())
                .build();
    }
}
