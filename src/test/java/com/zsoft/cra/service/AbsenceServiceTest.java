package com.zsoft.cra.service;

import com.zsoft.cra.CraApp;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AbsenceRepository;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CraApp.class)
public class AbsenceServiceTest {


    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private  AbsenceService absenceService;


    private final static String USER_LOGIN = "user";

    @Test
    public  void creatingAbsenceTest() {

        LocalDate date = LocalDate.now();


        Absence absence = absenceService.createAbsence(date, date.plus(1, ChronoUnit.DAYS),
            AbsenceType.SICKNESS_ABSENCE, "Shit happens", USER_LOGIN);
        assertTrue("Absence created in database successfully", absenceRepository.exists(absence.getId()));
    }


    @Test
    public void gettingAbsencesTest() {
        LocalDate date = LocalDate.now();

        User user = new User();
        user.setId("userAbsencesTest");
        user.setLogin("userAbsencesLogin");


        absenceService.createAbsence(date, date.plus(1, ChronoUnit.DAYS),
            AbsenceType.SICKNESS_ABSENCE, "Shit happens 1", USER_LOGIN);
        absenceService.createAbsence(date, date.plus(1, ChronoUnit.DAYS),
            AbsenceType.SICKNESS_ABSENCE, "Shit happens 2", USER_LOGIN);
        absenceService.createAbsence(date, date.plus(1, ChronoUnit.DAYS),
            AbsenceType.SICKNESS_ABSENCE, "Shit happens 3", USER_LOGIN);


        List<Absence> listOfAbsences = absenceService.getAbsences("userAbsencesLogin");


        assertTrue("Retrieving absences for user " + user.getLogin() + " successfully",
            listOfAbsences.size() == 3);
        for (Absence absence : listOfAbsences) {
            assertTrue("The user login retrieved is the same saved",
                absence.getUser().getLogin().equals(user.getLogin()));
        }

    }
}
