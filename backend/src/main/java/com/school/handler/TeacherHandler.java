package com.school.handler;

import com.school.domain.TeacherDomain;
import com.school.model.TeacherModel;
import com.school.service.SubjectService;
import com.school.service.TeacherService;
import com.school.transformer.TeacherTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TeacherHandler {
    private TeacherTransformer teacherTransformer;
    private TeacherService teacherService;

    public TeacherModel create(TeacherModel model){
        TeacherDomain teacherDomain = teacherTransformer.toEntity(model);
        teacherService.create(teacherDomain);
        return teacherTransformer.toModel(teacherDomain);
    }

    public List<TeacherModel> getAll(){
        List<TeacherDomain> teacherDomains = teacherService.getAll();

        return teacherDomains.stream()
                .map(teacherTransformer::toModel)
                .collect(Collectors.toList());
    }
}
