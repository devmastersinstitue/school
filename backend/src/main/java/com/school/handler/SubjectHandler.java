package com.school.handler;

import com.school.domain.StudentDomain;
import com.school.domain.SubjectDomain;
import com.school.model.StudentModel;
import com.school.model.SubjectModel;
import com.school.service.StudentService;
import com.school.service.SubjectService;
import com.school.transformer.StudentTransformer;
import com.school.transformer.SubjectTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SubjectHandler {
    private final SubjectTransformer subjectTransformer;
    private final SubjectService subjectService;

    public SubjectModel create(SubjectModel model){
        SubjectDomain subjectDomain =subjectTransformer.toEntity(model);
        subjectService.create(subjectDomain);
        return subjectTransformer.toModel(subjectDomain);
    }
    public List<SubjectModel> getAll() {
        List<SubjectDomain> subjectDomain =subjectService.getAll();

        return subjectDomain.stream()
                .map(subjectTransformer::toModel)
                .collect(Collectors.toList());
    }
}
