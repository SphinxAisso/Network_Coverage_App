package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository){
        this.absenceRepository = absenceRepository;
    }

    public Absence createAbsence(AbsenceDTO absenceDTO) {
        Absence absence = new Absence();
        absence.setStartDate(absenceDTO.getStartDate());
        absence.setEndDate(absenceDTO.getEndDate());
        absence.setAbsenceType(absenceDTO.getAbsenceType());
        this.absenceRepository.save(absence);
        log.debug("Created Information for Absence: {}", absence);
        return absence;
    }

    public List<Absence> getAllAbsences() {
        return this.absenceRepository.findAll();
    }


    /**
     * Update all information for a specific absence, and return the modified absence.
     *
     * @param absenceDTO absence to update
     * @return updated absence
     */
    public Optional<AbsenceDTO> updateAbsence(AbsenceDTO absenceDTO) {
        return Optional.of(absenceRepository
            .findOne(absenceDTO.getId()))
            .map(absence -> {
                absence.setStartDate(absenceDTO.getStartDate());
                absence.setEndDate(absenceDTO.getEndDate());
                absence.setAbsenceType(absenceDTO.getAbsenceType());
                absenceRepository.save(absence);
                log.debug("Changed Information for Absence: {}", absence);
                return absence;
            })
            .map(AbsenceDTO::new);
    }
}
