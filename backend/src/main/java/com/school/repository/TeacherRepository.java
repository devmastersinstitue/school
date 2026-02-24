package com.school.repository;


import com.school.domain.TeacherDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends MongoRepository<TeacherDomain, UUID> {
    Optional<TeacherDomain> findByPhoneNumberOrEmail(String phoneNumber, String email);
}

