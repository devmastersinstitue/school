package com.school.handler;

import com.school.domain.GradeDomain;
import com.school.model.GradeModel;
import com.school.repository.GradeRepository;
import com.school.service.GradeService;
import com.school.transformer.GradeTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GradeHandler {
    private final GradeTransformer gradeTransformer;
    private final GradeService gradeService;
    private final GradeRepository gradeRepository;

    public GradeModel create(GradeModel model){
        GradeDomain gradeDomain = gradeTransformer.toEntity(model);
        gradeService.create(gradeDomain);
        return gradeTransformer.toModel(gradeDomain);

    }

    public List<GradeModel> getAll(){
        List<GradeDomain> gradeDomain = gradeService.getAll();

        return gradeDomain.stream()
                .map(gradeTransformer::toModel)
                .collect(Collectors.toList());
    }
}
