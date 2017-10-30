package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AbsenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(AbsenceService.class);

    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public Absence createAbsence(LocalDate beginingDate, LocalDate endingDate, AbsenceType absenceType, String comment, User user) {

        log.info(String.format("creating a new absence for user %s", user.getLogin()));

        Absence absence = new Absence();
        absence.setBeginningDate(beginingDate);
        absence.setEndingDate(endingDate);
        absence.setAbsenceType(absenceType);
        absence.setComment(comment);
        absence.setComment(comment);
        absence.setUser(user);
        absenceRepository.save(absence);

        log.info(String.format("new absence has been added for user %s", user.getLogin()));
        return absence;
    }
}
