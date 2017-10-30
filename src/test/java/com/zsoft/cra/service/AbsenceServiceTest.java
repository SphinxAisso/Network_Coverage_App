package com.zsoft.cra.service;

import com.zsoft.cra.CraApp;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;
import com.zsoft.cra.repository.AbsenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CraApp.class)
public class AbsenceServiceTest {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private  AbsenceService absenceService;

    @Test
    public  void creatingAbsenceTest() {

        LocalDate date = LocalDate.now();
        User user = new User();
        user.setId("userTest");

        Absence absence = absenceService.createAbsence(date, date.plus(1, ChronoUnit.DAYS),
            AbsenceType.SICKNESS_ABSENCE,"Shit happens", user);
        assertTrue("Absence created in database successfully", absenceRepository.exists(absence.getId()));
    }

}
