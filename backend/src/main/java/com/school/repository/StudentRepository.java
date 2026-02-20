package com.school.repository;


import com.school.domain.StudentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReadPreference;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface StudentRepository extends MongoRepository<StudentDomain, UUID> {
}
