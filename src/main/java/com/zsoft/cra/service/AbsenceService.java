package com.zsoft.cra.service;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    private final Logger log = LoggerFactory.getLogger(AbsenceService.class);

    private final AbsenceRepository absenceRepository;


    private UserService userService;

    public AbsenceService(AbsenceRepository absenceRepository, UserService userService) {
        this.absenceRepository = absenceRepository;
        this.userService = userService;
    }

    public Absence createAbsence(LocalDate beginingDate, LocalDate endingDate, AbsenceType absenceType, String comment, String userLogin) {

        log.info(String.format("creating a new absence for user %s", userLogin));

        Absence absence = new Absence();
        absence.setBeginningDate(beginingDate);
        absence.setEndingDate(endingDate);
        absence.setAbsenceType(absenceType);
        absence.setComment(comment);

        // looking for the user
        Optional<User> userOptional = userService.getUserWithAuthoritiesByLogin(userLogin);
        if (userOptional.isPresent()) {
            absence.setUser(userOptional.get());
            absenceRepository.save(absence);
            log.info(String.format("new absence has been added for user %s", userLogin));
            return absence;
        } else {
            //TODO get the current user and affect the absence to him/her
            return null;
        }

    }

    public Absence createAbsence(AbsenceDTO absenceDTO) {

        return createAbsence(absenceDTO.getBeginningDate(), absenceDTO.getEndingDate(),
            absenceDTO.getAbsenceType(), absenceDTO.getComment(), absenceDTO.getUserLogin());
    }

    public List<Absence> getAbsences(String userLogin) {
        return null;
    }
}
