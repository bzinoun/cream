package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.repository.TacheRepository;
import ma.wafa.cream.service.TacheService;
import ma.wafa.cream.web.rest.dto.TacheDTO;
import ma.wafa.cream.web.rest.mapper.TacheMapper;

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
import org.springframework.util.Base64Utils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ma.wafa.cream.domain.enumeration.TypeTache;

/**
 * Test class for the TacheResource REST controller.
 *
 * @see TacheResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class TacheResourceIntTest {

    private static final String DEFAULT_SUJET = "AAAAA";
    private static final String UPDATED_SUJET = "BBBBB";
    private static final String DEFAULT_DESCRIPTION = "AAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN = LocalDate.now(ZoneId.systemDefault());


    private static final TypeTache DEFAULT_TYPE = TypeTache.TYPE1;
    private static final TypeTache UPDATED_TYPE = TypeTache.TYPE2;

    private static final byte[] DEFAULT_PIECE_JOINTE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PIECE_JOINTE = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_PIECE_JOINTE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PIECE_JOINTE_CONTENT_TYPE = "image/png";
    private static final String DEFAULT_USER = "AAAAA";
    private static final String UPDATED_USER = "BBBBB";

    @Inject
    private TacheRepository tacheRepository;

    @Inject
    private TacheMapper tacheMapper;

    @Inject
    private TacheService tacheService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restTacheMockMvc;

    private Tache tache;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        TacheResource tacheResource = new TacheResource();
        ReflectionTestUtils.setField(tacheResource, "tacheService", tacheService);
        ReflectionTestUtils.setField(tacheResource, "tacheMapper", tacheMapper);
        this.restTacheMockMvc = MockMvcBuilders.standaloneSetup(tacheResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        tache = new Tache();
        tache.setSujet(DEFAULT_SUJET);
        tache.setDescription(DEFAULT_DESCRIPTION);
        tache.setDateDebut(DEFAULT_DATE_DEBUT);
        tache.setDateFin(DEFAULT_DATE_FIN);
        tache.setType(DEFAULT_TYPE);
        tache.setPieceJointe(DEFAULT_PIECE_JOINTE);
        tache.setPieceJointeContentType(DEFAULT_PIECE_JOINTE_CONTENT_TYPE);
        tache.setUser(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void createTache() throws Exception {
        int databaseSizeBeforeCreate = tacheRepository.findAll().size();

        // Create the Tache
        TacheDTO tacheDTO = tacheMapper.tacheToTacheDTO(tache);

        restTacheMockMvc.perform(post("/api/taches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(tacheDTO)))
                .andExpect(status().isCreated());

        // Validate the Tache in the database
        List<Tache> taches = tacheRepository.findAll();
        assertThat(taches).hasSize(databaseSizeBeforeCreate + 1);
        Tache testTache = taches.get(taches.size() - 1);
        assertThat(testTache.getSujet()).isEqualTo(DEFAULT_SUJET);
        assertThat(testTache.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTache.getDateDebut()).isEqualTo(DEFAULT_DATE_DEBUT);
        assertThat(testTache.getDateFin()).isEqualTo(DEFAULT_DATE_FIN);
        assertThat(testTache.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testTache.getPieceJointe()).isEqualTo(DEFAULT_PIECE_JOINTE);
        assertThat(testTache.getPieceJointeContentType()).isEqualTo(DEFAULT_PIECE_JOINTE_CONTENT_TYPE);
        assertThat(testTache.getUser()).isEqualTo(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void checkSujetIsRequired() throws Exception {
        int databaseSizeBeforeTest = tacheRepository.findAll().size();
        // set the field null
        tache.setSujet(null);

        // Create the Tache, which fails.
        TacheDTO tacheDTO = tacheMapper.tacheToTacheDTO(tache);

        restTacheMockMvc.perform(post("/api/taches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(tacheDTO)))
                .andExpect(status().isBadRequest());

        List<Tache> taches = tacheRepository.findAll();
        assertThat(taches).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = tacheRepository.findAll().size();
        // set the field null
        tache.setType(null);

        // Create the Tache, which fails.
        TacheDTO tacheDTO = tacheMapper.tacheToTacheDTO(tache);

        restTacheMockMvc.perform(post("/api/taches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(tacheDTO)))
                .andExpect(status().isBadRequest());

        List<Tache> taches = tacheRepository.findAll();
        assertThat(taches).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllTaches() throws Exception {
        // Initialize the database
        tacheRepository.saveAndFlush(tache);

        // Get all the taches
        restTacheMockMvc.perform(get("/api/taches?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(tache.getId().intValue())))
                .andExpect(jsonPath("$.[*].sujet").value(hasItem(DEFAULT_SUJET.toString())))
                .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
                .andExpect(jsonPath("$.[*].dateDebut").value(hasItem(DEFAULT_DATE_DEBUT.toString())))
                .andExpect(jsonPath("$.[*].dateFin").value(hasItem(DEFAULT_DATE_FIN.toString())))
                .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
                .andExpect(jsonPath("$.[*].pieceJointeContentType").value(hasItem(DEFAULT_PIECE_JOINTE_CONTENT_TYPE)))
                .andExpect(jsonPath("$.[*].pieceJointe").value(hasItem(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE))))
                .andExpect(jsonPath("$.[*].user").value(hasItem(DEFAULT_USER.toString())));
    }

    @Test
    @Transactional
    public void getTache() throws Exception {
        // Initialize the database
        tacheRepository.saveAndFlush(tache);

        // Get the tache
        restTacheMockMvc.perform(get("/api/taches/{id}", tache.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(tache.getId().intValue()))
            .andExpect(jsonPath("$.sujet").value(DEFAULT_SUJET.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.dateDebut").value(DEFAULT_DATE_DEBUT.toString()))
            .andExpect(jsonPath("$.dateFin").value(DEFAULT_DATE_FIN.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.pieceJointeContentType").value(DEFAULT_PIECE_JOINTE_CONTENT_TYPE))
            .andExpect(jsonPath("$.pieceJointe").value(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE)))
            .andExpect(jsonPath("$.user").value(DEFAULT_USER.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingTache() throws Exception {
        // Get the tache
        restTacheMockMvc.perform(get("/api/taches/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTache() throws Exception {
        // Initialize the database
        tacheRepository.saveAndFlush(tache);

		int databaseSizeBeforeUpdate = tacheRepository.findAll().size();

        // Update the tache
        tache.setSujet(UPDATED_SUJET);
        tache.setDescription(UPDATED_DESCRIPTION);
        tache.setDateDebut(UPDATED_DATE_DEBUT);
        tache.setDateFin(UPDATED_DATE_FIN);
        tache.setType(UPDATED_TYPE);
        tache.setPieceJointe(UPDATED_PIECE_JOINTE);
        tache.setPieceJointeContentType(UPDATED_PIECE_JOINTE_CONTENT_TYPE);
        tache.setUser(UPDATED_USER);
        TacheDTO tacheDTO = tacheMapper.tacheToTacheDTO(tache);

        restTacheMockMvc.perform(put("/api/taches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(tacheDTO)))
                .andExpect(status().isOk());

        // Validate the Tache in the database
        List<Tache> taches = tacheRepository.findAll();
        assertThat(taches).hasSize(databaseSizeBeforeUpdate);
        Tache testTache = taches.get(taches.size() - 1);
        assertThat(testTache.getSujet()).isEqualTo(UPDATED_SUJET);
        assertThat(testTache.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTache.getDateDebut()).isEqualTo(UPDATED_DATE_DEBUT);
        assertThat(testTache.getDateFin()).isEqualTo(UPDATED_DATE_FIN);
        assertThat(testTache.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testTache.getPieceJointe()).isEqualTo(UPDATED_PIECE_JOINTE);
        assertThat(testTache.getPieceJointeContentType()).isEqualTo(UPDATED_PIECE_JOINTE_CONTENT_TYPE);
        assertThat(testTache.getUser()).isEqualTo(UPDATED_USER);
    }

    @Test
    @Transactional
    public void deleteTache() throws Exception {
        // Initialize the database
        tacheRepository.saveAndFlush(tache);

		int databaseSizeBeforeDelete = tacheRepository.findAll().size();

        // Get the tache
        restTacheMockMvc.perform(delete("/api/taches/{id}", tache.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Tache> taches = tacheRepository.findAll();
        assertThat(taches).hasSize(databaseSizeBeforeDelete - 1);
    }
}
