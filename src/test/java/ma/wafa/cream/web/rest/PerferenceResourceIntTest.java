package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Perference;
import ma.wafa.cream.repository.PerferenceRepository;
import ma.wafa.cream.service.PerferenceService;
import ma.wafa.cream.web.rest.dto.PerferenceDTO;
import ma.wafa.cream.web.rest.mapper.PerferenceMapper;

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
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the PerferenceResource REST controller.
 *
 * @see PerferenceResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class PerferenceResourceIntTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("Z"));

    private static final String DEFAULT_SUJET = "AAAAA";
    private static final String UPDATED_SUJET = "BBBBB";
    private static final String DEFAULT_DESCRIPTION = "AAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBB";

    private static final ZonedDateTime DEFAULT_DATE_IMPORT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneId.systemDefault());
    private static final ZonedDateTime UPDATED_DATE_IMPORT = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final String DEFAULT_DATE_IMPORT_STR = dateTimeFormatter.format(DEFAULT_DATE_IMPORT);

    private static final byte[] DEFAULT_PIECE_JOINTE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PIECE_JOINTE = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_PIECE_JOINTE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PIECE_JOINTE_CONTENT_TYPE = "image/png";

    @Inject
    private PerferenceRepository perferenceRepository;

    @Inject
    private PerferenceMapper perferenceMapper;

    @Inject
    private PerferenceService perferenceService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restPerferenceMockMvc;

    private Perference perference;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PerferenceResource perferenceResource = new PerferenceResource();
        ReflectionTestUtils.setField(perferenceResource, "perferenceService", perferenceService);
        ReflectionTestUtils.setField(perferenceResource, "perferenceMapper", perferenceMapper);
        this.restPerferenceMockMvc = MockMvcBuilders.standaloneSetup(perferenceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        perference = new Perference();
        perference.setSujet(DEFAULT_SUJET);
        perference.setDescription(DEFAULT_DESCRIPTION);
        perference.setDateImport(DEFAULT_DATE_IMPORT);
        perference.setPieceJointe(DEFAULT_PIECE_JOINTE);
        perference.setPieceJointeContentType(DEFAULT_PIECE_JOINTE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createPerference() throws Exception {
        int databaseSizeBeforeCreate = perferenceRepository.findAll().size();

        // Create the Perference
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);

        restPerferenceMockMvc.perform(post("/api/perferences")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perferenceDTO)))
                .andExpect(status().isCreated());

        // Validate the Perference in the database
        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeCreate + 1);
        Perference testPerference = perferences.get(perferences.size() - 1);
        assertThat(testPerference.getSujet()).isEqualTo(DEFAULT_SUJET);
        assertThat(testPerference.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testPerference.getDateImport()).isEqualTo(DEFAULT_DATE_IMPORT);
        assertThat(testPerference.getPieceJointe()).isEqualTo(DEFAULT_PIECE_JOINTE);
        assertThat(testPerference.getPieceJointeContentType()).isEqualTo(DEFAULT_PIECE_JOINTE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void checkSujetIsRequired() throws Exception {
        int databaseSizeBeforeTest = perferenceRepository.findAll().size();
        // set the field null
        perference.setSujet(null);

        // Create the Perference, which fails.
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);

        restPerferenceMockMvc.perform(post("/api/perferences")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perferenceDTO)))
                .andExpect(status().isBadRequest());

        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDateImportIsRequired() throws Exception {
        int databaseSizeBeforeTest = perferenceRepository.findAll().size();
        // set the field null
        perference.setDateImport(null);

        // Create the Perference, which fails.
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);

        restPerferenceMockMvc.perform(post("/api/perferences")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perferenceDTO)))
                .andExpect(status().isBadRequest());

        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPieceJointeIsRequired() throws Exception {
        int databaseSizeBeforeTest = perferenceRepository.findAll().size();
        // set the field null
        perference.setPieceJointe(null);

        // Create the Perference, which fails.
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);

        restPerferenceMockMvc.perform(post("/api/perferences")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perferenceDTO)))
                .andExpect(status().isBadRequest());

        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPerferences() throws Exception {
        // Initialize the database
        perferenceRepository.saveAndFlush(perference);

        // Get all the perferences
        restPerferenceMockMvc.perform(get("/api/perferences?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(perference.getId().intValue())))
                .andExpect(jsonPath("$.[*].sujet").value(hasItem(DEFAULT_SUJET.toString())))
                .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
                .andExpect(jsonPath("$.[*].dateImport").value(hasItem(DEFAULT_DATE_IMPORT_STR)))
                .andExpect(jsonPath("$.[*].pieceJointeContentType").value(hasItem(DEFAULT_PIECE_JOINTE_CONTENT_TYPE)))
                .andExpect(jsonPath("$.[*].pieceJointe").value(hasItem(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE))));
    }

    @Test
    @Transactional
    public void getPerference() throws Exception {
        // Initialize the database
        perferenceRepository.saveAndFlush(perference);

        // Get the perference
        restPerferenceMockMvc.perform(get("/api/perferences/{id}", perference.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(perference.getId().intValue()))
            .andExpect(jsonPath("$.sujet").value(DEFAULT_SUJET.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.dateImport").value(DEFAULT_DATE_IMPORT_STR))
            .andExpect(jsonPath("$.pieceJointeContentType").value(DEFAULT_PIECE_JOINTE_CONTENT_TYPE))
            .andExpect(jsonPath("$.pieceJointe").value(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE)));
    }

    @Test
    @Transactional
    public void getNonExistingPerference() throws Exception {
        // Get the perference
        restPerferenceMockMvc.perform(get("/api/perferences/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePerference() throws Exception {
        // Initialize the database
        perferenceRepository.saveAndFlush(perference);

		int databaseSizeBeforeUpdate = perferenceRepository.findAll().size();

        // Update the perference
        perference.setSujet(UPDATED_SUJET);
        perference.setDescription(UPDATED_DESCRIPTION);
        perference.setDateImport(UPDATED_DATE_IMPORT);
        perference.setPieceJointe(UPDATED_PIECE_JOINTE);
        perference.setPieceJointeContentType(UPDATED_PIECE_JOINTE_CONTENT_TYPE);
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);

        restPerferenceMockMvc.perform(put("/api/perferences")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perferenceDTO)))
                .andExpect(status().isOk());

        // Validate the Perference in the database
        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeUpdate);
        Perference testPerference = perferences.get(perferences.size() - 1);
        assertThat(testPerference.getSujet()).isEqualTo(UPDATED_SUJET);
        assertThat(testPerference.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testPerference.getDateImport()).isEqualTo(UPDATED_DATE_IMPORT);
        assertThat(testPerference.getPieceJointe()).isEqualTo(UPDATED_PIECE_JOINTE);
        assertThat(testPerference.getPieceJointeContentType()).isEqualTo(UPDATED_PIECE_JOINTE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void deletePerference() throws Exception {
        // Initialize the database
        perferenceRepository.saveAndFlush(perference);

		int databaseSizeBeforeDelete = perferenceRepository.findAll().size();

        // Get the perference
        restPerferenceMockMvc.perform(delete("/api/perferences/{id}", perference.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Perference> perferences = perferenceRepository.findAll();
        assertThat(perferences).hasSize(databaseSizeBeforeDelete - 1);
    }
}
