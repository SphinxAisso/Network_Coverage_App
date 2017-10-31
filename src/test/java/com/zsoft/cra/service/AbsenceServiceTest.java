package com.zsoft.cra.service;

import com.zsoft.cra.CraApp;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.zsoft.cra.domain.AbsenceType.SICKNESS_ABSENCE;
import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CraApp.class)
public class AbsenceServiceTest {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private AbsenceService absenceService;

    private final static String USER_LOGIN = "user";

    private final static LocalDate DATE = LocalDate.now();


    @Test
    public void creatingAbsenceTest() {

        Absence absence = absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens", USER_LOGIN);
        assertTrue("Absence created in database successfully", absenceRepository.exists(absence.getId()));
    }


    @Test
    public void getAbsencesTest() {

        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 1", USER_LOGIN);
        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 2", USER_LOGIN);
        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 3", USER_LOGIN);


        List<Absence> userAbsences = absenceService.getAbsences(USER_LOGIN);


        assertTrue(String.format("The number of absences added for %s is 3 absences  ", USER_LOGIN), userAbsences.size() == 3);


    }
}
