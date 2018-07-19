package com.zsoft.cra.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.AbsenceService;
import com.zsoft.cra.service.dto.AbsenceDTO;
import com.zsoft.cra.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Absence> createAbsence(@Valid @RequestBody AbsenceDTO absenceDTO) throws URISyntaxException {
            log.debug("REST request to save Absence : {}", absenceDTO);
            Absence newAbsence = absenceService.createAbsence(absenceDTO);
            return ResponseEntity.created(new URI("/absence/add-absence/"))
                .headers(HeaderUtil.createAlert( "absenceManagement.created", newAbsence.getAbsenceType()))
                .body(newAbsence);
    }

    @GetMapping("/absences")
    @Timed
    public List<Absence> getAbsences() throws URISyntaxException {

        return this.absenceService.getAllAbsences();
    }


    /**
     * PUT /absences : Updates an existing Absence.
     *
     * @param absenceDTO the absence to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated absence
     */
    @PutMapping("/absences")
    public ResponseEntity<AbsenceDTO> updateAbsence(@Valid @RequestBody AbsenceDTO absenceDTO) {
        log.debug("REST request to update absence : {}", absenceDTO);
        Optional<AbsenceDTO> updatedAbsence = absenceService.updateAbsence(absenceDTO);
        return ResponseUtil.wrapOrNotFound(updatedAbsence,
            HeaderUtil.createAlert("absence.updated", absenceDTO.getId()));
    }

}
