package com.zsoft.cra.repository;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data MongoDB repository for the Absence entity.
 */
@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {

    public List<Absence> findAbsencesByUser(User user);

    public Absence findById(String id);

}
