package com.school.service;

import com.school.domain.GradeDomain;
import com.school.repository.GradeRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class GradeService {
    private final GradeRepository gradeRepository;

    public void create(GradeDomain gradeDomain){
        Optional<GradeDomain> optionalGradeDomain = gradeRepository.findByClassNameOrClassSectionOrRoomNumber(
                gradeDomain.getClassName(),
                gradeDomain.getClassSection(),
                gradeDomain.getRoomNumber()
        );
        if(optionalGradeDomain.isEmpty()) {
            gradeRepository.save(gradeDomain);
        }
    }

    public List<GradeDomain> getAll() {
        return gradeRepository.findAll();
    }
}
