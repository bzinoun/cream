package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Compagne;
import ma.wafa.cream.repository.CompagneRepository;
import ma.wafa.cream.service.CompagneService;
import ma.wafa.cream.web.rest.dto.CompagneDTO;
import ma.wafa.cream.web.rest.mapper.CompagneMapper;

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
 * Test class for the CompagneResource REST controller.
 *
 * @see CompagneResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class CompagneResourceIntTest {

    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN = LocalDate.now(ZoneId.systemDefault());

    @Inject
    private CompagneRepository compagneRepository;

    @Inject
    private CompagneMapper compagneMapper;

    @Inject
    private CompagneService compagneService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restCompagneMockMvc;

    private Compagne compagne;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CompagneResource compagneResource = new CompagneResource();
        ReflectionTestUtils.setField(compagneResource, "compagneService", compagneService);
        ReflectionTestUtils.setField(compagneResource, "compagneMapper", compagneMapper);
        this.restCompagneMockMvc = MockMvcBuilders.standaloneSetup(compagneResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        compagne = new Compagne();
        compagne.setLibelle(DEFAULT_LIBELLE);
        compagne.setDateDebut(DEFAULT_DATE_DEBUT);
        compagne.setDateFin(DEFAULT_DATE_FIN);
    }

    @Test
    @Transactional
    public void createCompagne() throws Exception {
        int databaseSizeBeforeCreate = compagneRepository.findAll().size();

        // Create the Compagne
        CompagneDTO compagneDTO = compagneMapper.compagneToCompagneDTO(compagne);

        restCompagneMockMvc.perform(post("/api/compagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(compagneDTO)))
                .andExpect(status().isCreated());

        // Validate the Compagne in the database
        List<Compagne> compagnes = compagneRepository.findAll();
        assertThat(compagnes).hasSize(databaseSizeBeforeCreate + 1);
        Compagne testCompagne = compagnes.get(compagnes.size() - 1);
        assertThat(testCompagne.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testCompagne.getDateDebut()).isEqualTo(DEFAULT_DATE_DEBUT);
        assertThat(testCompagne.getDateFin()).isEqualTo(DEFAULT_DATE_FIN);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = compagneRepository.findAll().size();
        // set the field null
        compagne.setLibelle(null);

        // Create the Compagne, which fails.
        CompagneDTO compagneDTO = compagneMapper.compagneToCompagneDTO(compagne);

        restCompagneMockMvc.perform(post("/api/compagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(compagneDTO)))
                .andExpect(status().isBadRequest());

        List<Compagne> compagnes = compagneRepository.findAll();
        assertThat(compagnes).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCompagnes() throws Exception {
        // Initialize the database
        compagneRepository.saveAndFlush(compagne);

        // Get all the compagnes
        restCompagneMockMvc.perform(get("/api/compagnes?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(compagne.getId().intValue())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())))
                .andExpect(jsonPath("$.[*].dateDebut").value(hasItem(DEFAULT_DATE_DEBUT.toString())))
                .andExpect(jsonPath("$.[*].dateFin").value(hasItem(DEFAULT_DATE_FIN.toString())));
    }

    @Test
    @Transactional
    public void getCompagne() throws Exception {
        // Initialize the database
        compagneRepository.saveAndFlush(compagne);

        // Get the compagne
        restCompagneMockMvc.perform(get("/api/compagnes/{id}", compagne.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(compagne.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()))
            .andExpect(jsonPath("$.dateDebut").value(DEFAULT_DATE_DEBUT.toString()))
            .andExpect(jsonPath("$.dateFin").value(DEFAULT_DATE_FIN.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingCompagne() throws Exception {
        // Get the compagne
        restCompagneMockMvc.perform(get("/api/compagnes/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCompagne() throws Exception {
        // Initialize the database
        compagneRepository.saveAndFlush(compagne);

		int databaseSizeBeforeUpdate = compagneRepository.findAll().size();

        // Update the compagne
        compagne.setLibelle(UPDATED_LIBELLE);
        compagne.setDateDebut(UPDATED_DATE_DEBUT);
        compagne.setDateFin(UPDATED_DATE_FIN);
        CompagneDTO compagneDTO = compagneMapper.compagneToCompagneDTO(compagne);

        restCompagneMockMvc.perform(put("/api/compagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(compagneDTO)))
                .andExpect(status().isOk());

        // Validate the Compagne in the database
        List<Compagne> compagnes = compagneRepository.findAll();
        assertThat(compagnes).hasSize(databaseSizeBeforeUpdate);
        Compagne testCompagne = compagnes.get(compagnes.size() - 1);
        assertThat(testCompagne.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testCompagne.getDateDebut()).isEqualTo(UPDATED_DATE_DEBUT);
        assertThat(testCompagne.getDateFin()).isEqualTo(UPDATED_DATE_FIN);
    }

    @Test
    @Transactional
    public void deleteCompagne() throws Exception {
        // Initialize the database
        compagneRepository.saveAndFlush(compagne);

		int databaseSizeBeforeDelete = compagneRepository.findAll().size();

        // Get the compagne
        restCompagneMockMvc.perform(delete("/api/compagnes/{id}", compagne.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Compagne> compagnes = compagneRepository.findAll();
        assertThat(compagnes).hasSize(databaseSizeBeforeDelete - 1);
    }
}
