package com.zsoft.cra.web.rest;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.AbsenceService;
import com.zsoft.cra.service.dto.AbsenceDTO;
import com.zsoft.cra.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

    @GetMapping("/absences{userLogin}")
    public List<Absence> getAbsences(@PathVariable("userLogin") String userLogin) {
        return new ArrayList<Absence>();
    }

}
