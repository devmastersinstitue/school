package com.school.service;

import com.school.domain.StudentDomain;
import com.school.domain.SubjectDomain;
import com.school.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public void create(SubjectDomain subjectDomain) {
        Optional<SubjectDomain> optionalSubjectDomain = subjectRepository.findByNameOrCode(
                subjectDomain.getName(),
                subjectDomain.getCode()
        );
        if (optionalSubjectDomain.isEmpty()){
            subjectRepository.save(subjectDomain);
        }
    }
    public List<SubjectDomain> getAll() {
        return subjectRepository.findAll();
    }
}
