package com.zsoft.cra.repository;

import com.zsoft.cra.domain.Absence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data MongoDB repository for the Absence entity.
 */
@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {
    List<Absence> findAllByUser_Login(String userLogin);
}
