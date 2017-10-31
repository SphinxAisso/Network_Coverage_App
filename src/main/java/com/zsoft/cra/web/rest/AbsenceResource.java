package com.zsoft.cra.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.security.AuthoritiesConstants;
import com.zsoft.cra.service.AbsenceService;
import com.zsoft.cra.service.dto.AbsenceDTO;
import com.zsoft.cra.service.dto.UserDTO;
import com.zsoft.cra.web.rest.util.HeaderUtil;
import com.zsoft.cra.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AbsenceResource {

    private final Logger logger = LoggerFactory.getLogger(AbsenceResource.class);

    private final AbsenceRepository absenceRepository;

    private final AbsenceService absenceService;

    private final static String PREFIX = "/api/absences/";

    public AbsenceResource(AbsenceRepository absenceRepository, AbsenceService absenceService) {
        this.absenceRepository = absenceRepository;
        this.absenceService = absenceService;
    }

    @PostMapping("/absence")
    public ResponseEntity createUser(@RequestBody AbsenceDTO absenceDTO) throws URISyntaxException {
        Absence newAbsence = absenceService.createAbsence(absenceDTO);
        return ResponseEntity.created(new URI(PREFIX + newAbsence.getAbsenceType()))
            .headers(HeaderUtil.createAlert("absenceManagement.created", newAbsence.getAbsenceType().toString()))
            .body(newAbsence);
    }

    @GetMapping("/absences")
    public List<Absence> getAbsencesWithUserLogin(@PathVariable String userLogin) {
        return absenceService.getAbsences(userLogin);
    }

}
