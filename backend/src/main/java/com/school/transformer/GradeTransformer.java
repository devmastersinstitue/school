package com.school.transformer;

import com.school.domain.GradeDomain;
import com.school.model.GradeModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GradeTransformer extends Transformer<GradeDomain, GradeModel> {
    @Override
    public GradeDomain toEntity(GradeModel model){
        if(model == null)
            return null;
        return GradeDomain.builder()
                .id(model.getId() == null ? UUID.randomUUID() : model.getId())
                .className(model.getClassName())
                .classSection((model.getClassSection()))
                .classTeacherId((model.getClassTeacherId()))
                .roomNumber((model.getRoomNumber()))
                .capacity((model.getCapacity()))
                .build();
    }

    @Override
    public GradeModel toModel(GradeDomain entity){
        if(entity == null)
            return null;
        return GradeModel.builder()
                .id(entity.getId())
                .className(entity.getClassName())
                .classSection(entity.getClassSection())
                .classTeacherId(entity.getClassTeacherId())
                .roomNumber(entity.getRoomNumber())
                .capacity(entity.getCapacity())
                .build();


    }


}
