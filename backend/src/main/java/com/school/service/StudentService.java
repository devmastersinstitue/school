package com.school.service;

import com.school.domain.StudentDomain;
import com.school.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void create(StudentDomain studentDomain) {
        Optional<StudentDomain> optionalStudentDomain = studentRepository.
          findByFirstNameAndLastNameAndFatherNameAndContactNumber(
                  studentDomain.getFirstName(),
                  studentDomain.getLastName(),
                  studentDomain.getFatherName(),
                  studentDomain.getContactNumber());
        if(optionalStudentDomain.isEmpty()){
            studentRepository.save(studentDomain);
        }

    }
    public List<StudentDomain> getAll() {
        return studentRepository.findAll();
    }
}
