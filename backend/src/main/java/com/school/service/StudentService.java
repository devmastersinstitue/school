package com.school.service;

import com.school.domain.StudentDomain;
import com.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public void create(StudentDomain studentDomain) {
        studentRepository.save(studentDomain);
    }
}
