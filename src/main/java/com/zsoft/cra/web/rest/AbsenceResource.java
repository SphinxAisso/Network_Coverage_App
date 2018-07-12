package com.zsoft.cra.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.security.AuthoritiesConstants;
import com.zsoft.cra.service.AbsenceService;
import com.zsoft.cra.service.dto.AbsenceDTO;
import com.zsoft.cra.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/api")
public class AbsenceResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final AbsenceRepository absenceRepository;

    private final AbsenceService absenceService;

    public AbsenceResource(AbsenceRepository absenceRepository, AbsenceService absenceService) {

        this.absenceRepository = absenceRepository;
        this.absenceService = absenceService;

    }

    /**
     * POST  /add-absence  : Creates a new absence.
     * <p>
     * Creates a new absence
     *
     * @param absenceDTO the absence to create
     * @return the ResponseEntity with status 201 (Created) and with body the new user, or with status 400 (Bad Request) if the login or email is already in use
     */
    @PostMapping("/absences")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<Absence> createUser(@Valid @RequestBody AbsenceDTO absenceDTO) throws URISyntaxException {
            log.debug("REST request to save Absence : {}", absenceDTO);
            Absence newAbsence = absenceService.createAbsence(absenceDTO);
            return ResponseEntity.created(new URI("/absence/add-absence/"))
                .headers(HeaderUtil.createAlert( "absenceManagement.created", newAbsence.getAbsenceType()))
                .body(newAbsence);
    }
}





