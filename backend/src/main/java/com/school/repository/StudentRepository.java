package com.school.repository;


import com.school.domain.StudentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;


public interface StudentRepository extends MongoRepository<StudentDomain, UUID> {
    Optional<StudentDomain> findByFirstNameAndLastNameAndFatherNameAndContactNumber(String firstName, String lastName,
                                               String fatherName, String contactNumber);

}
