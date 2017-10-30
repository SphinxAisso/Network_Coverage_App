package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AbsenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(AbsenceService.class);
    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public Absence createAbsence(LocalDate beginingDate, LocalDate endingDate, AbsenceType absenceType, String comment, User user) {
        return null;
    }
}
