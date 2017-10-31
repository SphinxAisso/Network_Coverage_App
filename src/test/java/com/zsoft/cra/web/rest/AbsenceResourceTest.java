package com.zsoft.cra.web.rest;

import com.zsoft.cra.CraApp;
import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.repository.AbsenceRepository;
import com.zsoft.cra.service.AbsenceService;
import com.zsoft.cra.service.dto.AbsenceDTO;
import com.zsoft.cra.web.rest.errors.ExceptionTranslator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.zsoft.cra.domain.AbsenceType.UNJUSTIFIED_ABSENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for the AbsenceResource REST controller.
 *
 * @see AbsenceResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CraApp.class)
public class AbsenceResourceTest {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restAbsenceCLientMockMvc;

    private LocalDate date = LocalDate.now();

    private static String ID = "absence";

    private static String COMMENT = "unjustified absence";

    private static String USER_LOGIN = "user";

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        AbsenceResource absenceResource = new AbsenceResource(absenceRepository, absenceService);
        restAbsenceCLientMockMvc = MockMvcBuilders.standaloneSetup(absenceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter)
            .build();

    }

    @Test
    public void createAbsenceTest() throws Exception {

        int databaseSizeBeforeCreate = absenceRepository.findAll().size();

        AbsenceDTO absenceDTO = new AbsenceDTO(
            ID,
            date,
            date.plus(1, ChronoUnit.DAYS),
            UNJUSTIFIED_ABSENCE,
            COMMENT,
            USER_LOGIN
        );

        restAbsenceCLientMockMvc.perform(post("/api/absence")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(absenceDTO)))
            .andExpect(status().isCreated());

        List<Absence> absencesList = absenceRepository.findAll();
        assertThat(absencesList).hasSize(databaseSizeBeforeCreate + 1);

        Absence testAbsence = absencesList.get(absencesList.size() - 1);

        assertThat(testAbsence.getBeginningDate()).isEqualTo(date);
        assertThat(testAbsence.getEndingDate()).isEqualTo(date.plus(1, ChronoUnit.DAYS));
        assertThat(testAbsence.getComment()).isEqualTo(COMMENT);
        assertThat(testAbsence.getUser().getLogin()).isEqualTo(USER_LOGIN);
    }

    @Test
    public void getAbsences() throws Exception {

        restAbsenceCLientMockMvc.perform(get("/api/absences")
            .param("userLogin", USER_LOGIN)
            .contentType(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());


    }

}
