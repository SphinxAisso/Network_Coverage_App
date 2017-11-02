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
            SICKNESS_ABSENCE, "Headache", USER_LOGIN);

        assertTrue("Absence created in database successfully", absenceRepository.exists(absence.getId()));

    }


    @Test
    public void getAbsencesTest() {

        int absencesNbr = (int) absenceRepository.count();

        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 1", USER_LOGIN);
        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 2", USER_LOGIN);
        absenceService.createAbsence(DATE, DATE.plus(1, ChronoUnit.DAYS),
            SICKNESS_ABSENCE, "Shit happens 3", USER_LOGIN);


        List<Absence> userAbsences = absenceService.getAbsences(USER_LOGIN);
        assertTrue(USER_LOGIN + "has " + userAbsences.size() + " absences", userAbsences.size() == absencesNbr + 3);

    }

    @Test
    public void deleteAbsence() {

        Absence absence = new Absence();
        absence.setId("absence-01");
        absence.setAbsenceType(SICKNESS_ABSENCE);
        absence.setComment("Headache");
        absence.setEndingDate(DATE.plus(1, ChronoUnit.DAYS));
        absence.setBeginningDate(DATE);

        absenceRepository.save(absence);

        assertTrue(String.format("'%s' has been removed successfully", absence.getId()), absenceService.deleteAbsence(absence.getId()));

    }

    @Test
    public void editAbsence() {
        Absence absence = new Absence();
        absence.setId("absence-01");
        absence.setAbsenceType(SICKNESS_ABSENCE);
        absence.setComment("Headache");
        absence.setEndingDate(DATE.plus(1, ChronoUnit.DAYS));
        absence.setBeginningDate(DATE);

        absenceRepository.save(absence);

        absence.setEndingDate(DATE.plus(5, ChronoUnit.DAYS));

        absenceService.editAbsence(absence);

        Absence editedAbsence = absenceRepository.findById(absence.getId());

        assertTrue(String.format("'%s' has been edited successfully", absence.getId()), !editedAbsence.equals(absence));


    }
}
