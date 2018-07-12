package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);


    public AbsenceService(){}

    public Absence createAbsence(AbsenceDTO absenceDTO) {
        Absence absence = new Absence();
        absence.setAbsenceType(absenceDTO.getAbsenceType());
        absence.setStartDate(absenceDTO.getStartDate());
        absence.setEndDate(absenceDTO.getEndDate());
        log.debug("Created Information for User: {}", absence);
        return absence;
    }
}
