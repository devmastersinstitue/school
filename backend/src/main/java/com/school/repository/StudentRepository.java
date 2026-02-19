package com.school.repository;


import com.school.domain.StudentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentRepository extends MongoRepository<StudentDomain, UUID> {
}
