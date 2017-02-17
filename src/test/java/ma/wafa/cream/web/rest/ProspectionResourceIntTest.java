package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.repository.ProspectionRepository;
import ma.wafa.cream.service.ProspectionService;
import ma.wafa.cream.web.rest.dto.ProspectionDTO;
import ma.wafa.cream.web.rest.mapper.ProspectionMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the ProspectionResource REST controller.
 *
 * @see ProspectionResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ProspectionResourceIntTest {

    private static final String DEFAULT_SUJET = "AAAAA";
    private static final String UPDATED_SUJET = "BBBBB";
    private static final String DEFAULT_DESCRIPTION = "AAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN = LocalDate.now(ZoneId.systemDefault());
    private static final String DEFAULT_IMMATRICULATION = "AAAAA";
    private static final String UPDATED_IMMATRICULATION = "BBBBB";
    private static final String DEFAULT_MARQUE = "AAAAA";
    private static final String UPDATED_MARQUE = "BBBBB";
    private static final String DEFAULT_MODELE = "AAAAA";
    private static final String UPDATED_MODELE = "BBBBB";
    private static final String DEFAULT_USAGE_LIBELLE = "AAAAA";
    private static final String UPDATED_USAGE_LIBELLE = "BBBBB";
    private static final String DEFAULT_CODE_USAGE = "AAAAA";
    private static final String UPDATED_CODE_USAGE = "BBBBB";
    private static final String DEFAULT_ENERGIE = "AAAAA";
    private static final String UPDATED_ENERGIE = "BBBBB";

    private static final Integer DEFAULT_ANNEE_VIGNETTE = 1;
    private static final Integer UPDATED_ANNEE_VIGNETTE = 2;
    private static final String DEFAULT_USER = "AAAAA";
    private static final String UPDATED_USER = "BBBBB";

    @Inject
    private ProspectionRepository prospectionRepository;

    @Inject
    private ProspectionMapper prospectionMapper;

    @Inject
    private ProspectionService prospectionService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restProspectionMockMvc;

    private Prospection prospection;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProspectionResource prospectionResource = new ProspectionResource();
        ReflectionTestUtils.setField(prospectionResource, "prospectionService", prospectionService);
        ReflectionTestUtils.setField(prospectionResource, "prospectionMapper", prospectionMapper);
        this.restProspectionMockMvc = MockMvcBuilders.standaloneSetup(prospectionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        prospection = new Prospection();
        prospection.setSujet(DEFAULT_SUJET);
        prospection.setDescription(DEFAULT_DESCRIPTION);
        prospection.setDateDebut(DEFAULT_DATE_DEBUT);
        prospection.setDateFin(DEFAULT_DATE_FIN);
        prospection.setImmatriculation(DEFAULT_IMMATRICULATION);
        prospection.setMarque(DEFAULT_MARQUE);
        prospection.setModele(DEFAULT_MODELE);
        prospection.setUsageLibelle(DEFAULT_USAGE_LIBELLE);
        prospection.setCodeUsage(DEFAULT_CODE_USAGE);
        prospection.setEnergie(DEFAULT_ENERGIE);
        prospection.setAnneeVignette(DEFAULT_ANNEE_VIGNETTE);
        prospection.setUser(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void createProspection() throws Exception {
        int databaseSizeBeforeCreate = prospectionRepository.findAll().size();

        // Create the Prospection
        ProspectionDTO prospectionDTO = prospectionMapper.prospectionToProspectionDTO(prospection);

        restProspectionMockMvc.perform(post("/api/prospections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(prospectionDTO)))
                .andExpect(status().isCreated());

        // Validate the Prospection in the database
        List<Prospection> prospections = prospectionRepository.findAll();
        assertThat(prospections).hasSize(databaseSizeBeforeCreate + 1);
        Prospection testProspection = prospections.get(prospections.size() - 1);
        assertThat(testProspection.getSujet()).isEqualTo(DEFAULT_SUJET);
        assertThat(testProspection.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testProspection.getDateDebut()).isEqualTo(DEFAULT_DATE_DEBUT);
        assertThat(testProspection.getDateFin()).isEqualTo(DEFAULT_DATE_FIN);
        assertThat(testProspection.getImmatriculation()).isEqualTo(DEFAULT_IMMATRICULATION);
        assertThat(testProspection.getMarque()).isEqualTo(DEFAULT_MARQUE);
        assertThat(testProspection.getModele()).isEqualTo(DEFAULT_MODELE);
        assertThat(testProspection.getUsageLibelle()).isEqualTo(DEFAULT_USAGE_LIBELLE);
        assertThat(testProspection.getCodeUsage()).isEqualTo(DEFAULT_CODE_USAGE);
        assertThat(testProspection.getEnergie()).isEqualTo(DEFAULT_ENERGIE);
        assertThat(testProspection.getAnneeVignette()).isEqualTo(DEFAULT_ANNEE_VIGNETTE);
        assertThat(testProspection.getUser()).isEqualTo(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void checkSujetIsRequired() throws Exception {
        int databaseSizeBeforeTest = prospectionRepository.findAll().size();
        // set the field null
        prospection.setSujet(null);

        // Create the Prospection, which fails.
        ProspectionDTO prospectionDTO = prospectionMapper.prospectionToProspectionDTO(prospection);

        restProspectionMockMvc.perform(post("/api/prospections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(prospectionDTO)))
                .andExpect(status().isBadRequest());

        List<Prospection> prospections = prospectionRepository.findAll();
        assertThat(prospections).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProspections() throws Exception {
        // Initialize the database
        prospectionRepository.saveAndFlush(prospection);

        // Get all the prospections
        restProspectionMockMvc.perform(get("/api/prospections?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(prospection.getId().intValue())))
                .andExpect(jsonPath("$.[*].sujet").value(hasItem(DEFAULT_SUJET.toString())))
                .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
                .andExpect(jsonPath("$.[*].dateDebut").value(hasItem(DEFAULT_DATE_DEBUT.toString())))
                .andExpect(jsonPath("$.[*].dateFin").value(hasItem(DEFAULT_DATE_FIN.toString())))
                .andExpect(jsonPath("$.[*].immatriculation").value(hasItem(DEFAULT_IMMATRICULATION.toString())))
                .andExpect(jsonPath("$.[*].marque").value(hasItem(DEFAULT_MARQUE.toString())))
                .andExpect(jsonPath("$.[*].modele").value(hasItem(DEFAULT_MODELE.toString())))
                .andExpect(jsonPath("$.[*].usageLibelle").value(hasItem(DEFAULT_USAGE_LIBELLE.toString())))
                .andExpect(jsonPath("$.[*].codeUsage").value(hasItem(DEFAULT_CODE_USAGE.toString())))
                .andExpect(jsonPath("$.[*].energie").value(hasItem(DEFAULT_ENERGIE.toString())))
                .andExpect(jsonPath("$.[*].anneeVignette").value(hasItem(DEFAULT_ANNEE_VIGNETTE)))
                .andExpect(jsonPath("$.[*].user").value(hasItem(DEFAULT_USER.toString())));
    }

    @Test
    @Transactional
    public void getProspection() throws Exception {
        // Initialize the database
        prospectionRepository.saveAndFlush(prospection);

        // Get the prospection
        restProspectionMockMvc.perform(get("/api/prospections/{id}", prospection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(prospection.getId().intValue()))
            .andExpect(jsonPath("$.sujet").value(DEFAULT_SUJET.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.dateDebut").value(DEFAULT_DATE_DEBUT.toString()))
            .andExpect(jsonPath("$.dateFin").value(DEFAULT_DATE_FIN.toString()))
            .andExpect(jsonPath("$.immatriculation").value(DEFAULT_IMMATRICULATION.toString()))
            .andExpect(jsonPath("$.marque").value(DEFAULT_MARQUE.toString()))
            .andExpect(jsonPath("$.modele").value(DEFAULT_MODELE.toString()))
            .andExpect(jsonPath("$.usageLibelle").value(DEFAULT_USAGE_LIBELLE.toString()))
            .andExpect(jsonPath("$.codeUsage").value(DEFAULT_CODE_USAGE.toString()))
            .andExpect(jsonPath("$.energie").value(DEFAULT_ENERGIE.toString()))
            .andExpect(jsonPath("$.anneeVignette").value(DEFAULT_ANNEE_VIGNETTE))
            .andExpect(jsonPath("$.user").value(DEFAULT_USER.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProspection() throws Exception {
        // Get the prospection
        restProspectionMockMvc.perform(get("/api/prospections/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProspection() throws Exception {
        // Initialize the database
        prospectionRepository.saveAndFlush(prospection);

		int databaseSizeBeforeUpdate = prospectionRepository.findAll().size();

        // Update the prospection
        prospection.setSujet(UPDATED_SUJET);
        prospection.setDescription(UPDATED_DESCRIPTION);
        prospection.setDateDebut(UPDATED_DATE_DEBUT);
        prospection.setDateFin(UPDATED_DATE_FIN);
        prospection.setImmatriculation(UPDATED_IMMATRICULATION);
        prospection.setMarque(UPDATED_MARQUE);
        prospection.setModele(UPDATED_MODELE);
        prospection.setUsageLibelle(UPDATED_USAGE_LIBELLE);
        prospection.setCodeUsage(UPDATED_CODE_USAGE);
        prospection.setEnergie(UPDATED_ENERGIE);
        prospection.setAnneeVignette(UPDATED_ANNEE_VIGNETTE);
        prospection.setUser(UPDATED_USER);
        ProspectionDTO prospectionDTO = prospectionMapper.prospectionToProspectionDTO(prospection);

        restProspectionMockMvc.perform(put("/api/prospections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(prospectionDTO)))
                .andExpect(status().isOk());

        // Validate the Prospection in the database
        List<Prospection> prospections = prospectionRepository.findAll();
        assertThat(prospections).hasSize(databaseSizeBeforeUpdate);
        Prospection testProspection = prospections.get(prospections.size() - 1);
        assertThat(testProspection.getSujet()).isEqualTo(UPDATED_SUJET);
        assertThat(testProspection.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testProspection.getDateDebut()).isEqualTo(UPDATED_DATE_DEBUT);
        assertThat(testProspection.getDateFin()).isEqualTo(UPDATED_DATE_FIN);
        assertThat(testProspection.getImmatriculation()).isEqualTo(UPDATED_IMMATRICULATION);
        assertThat(testProspection.getMarque()).isEqualTo(UPDATED_MARQUE);
        assertThat(testProspection.getModele()).isEqualTo(UPDATED_MODELE);
        assertThat(testProspection.getUsageLibelle()).isEqualTo(UPDATED_USAGE_LIBELLE);
        assertThat(testProspection.getCodeUsage()).isEqualTo(UPDATED_CODE_USAGE);
        assertThat(testProspection.getEnergie()).isEqualTo(UPDATED_ENERGIE);
        assertThat(testProspection.getAnneeVignette()).isEqualTo(UPDATED_ANNEE_VIGNETTE);
        assertThat(testProspection.getUser()).isEqualTo(UPDATED_USER);
    }

    @Test
    @Transactional
    public void deleteProspection() throws Exception {
        // Initialize the database
        prospectionRepository.saveAndFlush(prospection);

		int databaseSizeBeforeDelete = prospectionRepository.findAll().size();

        // Get the prospection
        restProspectionMockMvc.perform(delete("/api/prospections/{id}", prospection.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Prospection> prospections = prospectionRepository.findAll();
        assertThat(prospections).hasSize(databaseSizeBeforeDelete - 1);
    }
}
