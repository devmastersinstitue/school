package com.school.service;

import com.school.domain.TeacherDomain;
import com.school.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public void create(TeacherDomain teacherDomain) {
        Optional<TeacherDomain> optionalTeacherDomain = teacherRepository.findByPhoneNumberOrEmail(
                teacherDomain.getPhoneNumber(),
                teacherDomain.getEmail()
                );
        if (optionalTeacherDomain.isEmpty()){
            teacherRepository.save(teacherDomain);
        }
    }
    public List<TeacherDomain> getAll(){
        return teacherRepository.findAll();
    }
}