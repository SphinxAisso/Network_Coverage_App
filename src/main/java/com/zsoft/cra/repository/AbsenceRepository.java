package com.zsoft.cra.repository;

import com.zsoft.cra.domain.Absence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbsenceRepository extends MongoRepository<Absence, String> {
}
