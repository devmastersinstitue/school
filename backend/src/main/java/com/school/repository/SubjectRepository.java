package com.school.repository;


import com.school.domain.StudentDomain;
import com.school.domain.SubjectDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubjectRepository extends MongoRepository<SubjectDomain, UUID> {
    Optional<SubjectDomain> findByNameOrCode(String name, String Code);
}
