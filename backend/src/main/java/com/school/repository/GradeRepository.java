package com.school.repository;


import com.school.domain.GradeDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface GradeRepository extends MongoRepository<GradeDomain, UUID> {
    Optional<GradeDomain> findByClassNameOrClassSectionOrRoomNumber(String className,
                                             String classSection, String roomNumber);
}
