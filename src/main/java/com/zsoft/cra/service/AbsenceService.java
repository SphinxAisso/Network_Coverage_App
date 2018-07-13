package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository){
        this.absenceRepository = absenceRepository;
    }

    public Absence createAbsence(AbsenceDTO absenceDTO) {
        Absence absence = new Absence();
        absence.setAbsenceType(absenceDTO.getAbsenceType());
        absence.setStartDate(absenceDTO.getStartDate());
        absence.setEndDate(absenceDTO.getEndDate());
        log.debug("Created Information for User: {}", absence);
        return absence;
    }

    public List<Absence> getAllAbsences() {
        return this.absenceRepository.findAll();
    }

}
