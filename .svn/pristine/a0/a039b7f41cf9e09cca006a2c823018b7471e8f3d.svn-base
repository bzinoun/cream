package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.RefStatutProspection;
import ma.wafa.cream.repository.RefStatutProspectionRepository;
import ma.wafa.cream.repository.search.RefStatutProspectionSearchRepository;
import ma.wafa.cream.web.rest.dto.RefStatutProspectionDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutProspectionMapper;

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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the RefStatutProspectionResource REST controller.
 *
 * @see RefStatutProspectionResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RefStatutProspectionResourceIntTest {

    private static final String DEFAULT_CODE = "AAAAA";
    private static final String UPDATED_CODE = "BBBBB";
    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    @Inject
    private RefStatutProspectionRepository refStatutProspectionRepository;

    @Inject
    private RefStatutProspectionMapper refStatutProspectionMapper;

    @Inject
    private RefStatutProspectionSearchRepository refStatutProspectionSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restRefStatutProspectionMockMvc;

    private RefStatutProspection refStatutProspection;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RefStatutProspectionResource refStatutProspectionResource = new RefStatutProspectionResource();
        ReflectionTestUtils.setField(refStatutProspectionResource, "refStatutProspectionSearchRepository", refStatutProspectionSearchRepository);
        ReflectionTestUtils.setField(refStatutProspectionResource, "refStatutProspectionRepository", refStatutProspectionRepository);
        ReflectionTestUtils.setField(refStatutProspectionResource, "refStatutProspectionMapper", refStatutProspectionMapper);
        this.restRefStatutProspectionMockMvc = MockMvcBuilders.standaloneSetup(refStatutProspectionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        refStatutProspection = new RefStatutProspection();
        refStatutProspection.setCode(DEFAULT_CODE);
        refStatutProspection.setLibelle(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createRefStatutProspection() throws Exception {
        int databaseSizeBeforeCreate = refStatutProspectionRepository.findAll().size();

        // Create the RefStatutProspection
        RefStatutProspectionDTO refStatutProspectionDTO = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);

        restRefStatutProspectionMockMvc.perform(post("/api/refStatutProspections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutProspectionDTO)))
                .andExpect(status().isCreated());

        // Validate the RefStatutProspection in the database
        List<RefStatutProspection> refStatutProspections = refStatutProspectionRepository.findAll();
        assertThat(refStatutProspections).hasSize(databaseSizeBeforeCreate + 1);
        RefStatutProspection testRefStatutProspection = refStatutProspections.get(refStatutProspections.size() - 1);
        assertThat(testRefStatutProspection.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRefStatutProspection.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutProspectionRepository.findAll().size();
        // set the field null
        refStatutProspection.setCode(null);

        // Create the RefStatutProspection, which fails.
        RefStatutProspectionDTO refStatutProspectionDTO = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);

        restRefStatutProspectionMockMvc.perform(post("/api/refStatutProspections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutProspectionDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutProspection> refStatutProspections = refStatutProspectionRepository.findAll();
        assertThat(refStatutProspections).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutProspectionRepository.findAll().size();
        // set the field null
        refStatutProspection.setLibelle(null);

        // Create the RefStatutProspection, which fails.
        RefStatutProspectionDTO refStatutProspectionDTO = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);

        restRefStatutProspectionMockMvc.perform(post("/api/refStatutProspections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutProspectionDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutProspection> refStatutProspections = refStatutProspectionRepository.findAll();
        assertThat(refStatutProspections).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRefStatutProspections() throws Exception {
        // Initialize the database
        refStatutProspectionRepository.saveAndFlush(refStatutProspection);

        // Get all the refStatutProspections
        restRefStatutProspectionMockMvc.perform(get("/api/refStatutProspections?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(refStatutProspection.getId().intValue())))
                .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())));
    }

    @Test
    @Transactional
    public void getRefStatutProspection() throws Exception {
        // Initialize the database
        refStatutProspectionRepository.saveAndFlush(refStatutProspection);

        // Get the refStatutProspection
        restRefStatutProspectionMockMvc.perform(get("/api/refStatutProspections/{id}", refStatutProspection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(refStatutProspection.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRefStatutProspection() throws Exception {
        // Get the refStatutProspection
        restRefStatutProspectionMockMvc.perform(get("/api/refStatutProspections/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRefStatutProspection() throws Exception {
        // Initialize the database
        refStatutProspectionRepository.saveAndFlush(refStatutProspection);

		int databaseSizeBeforeUpdate = refStatutProspectionRepository.findAll().size();

        // Update the refStatutProspection
        refStatutProspection.setCode(UPDATED_CODE);
        refStatutProspection.setLibelle(UPDATED_LIBELLE);
        RefStatutProspectionDTO refStatutProspectionDTO = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);

        restRefStatutProspectionMockMvc.perform(put("/api/refStatutProspections")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutProspectionDTO)))
                .andExpect(status().isOk());

        // Validate the RefStatutProspection in the database
        List<RefStatutProspection> refStatutProspections = refStatutProspectionRepository.findAll();
        assertThat(refStatutProspections).hasSize(databaseSizeBeforeUpdate);
        RefStatutProspection testRefStatutProspection = refStatutProspections.get(refStatutProspections.size() - 1);
        assertThat(testRefStatutProspection.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRefStatutProspection.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void deleteRefStatutProspection() throws Exception {
        // Initialize the database
        refStatutProspectionRepository.saveAndFlush(refStatutProspection);

		int databaseSizeBeforeDelete = refStatutProspectionRepository.findAll().size();

        // Get the refStatutProspection
        restRefStatutProspectionMockMvc.perform(delete("/api/refStatutProspections/{id}", refStatutProspection.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<RefStatutProspection> refStatutProspections = refStatutProspectionRepository.findAll();
        assertThat(refStatutProspections).hasSize(databaseSizeBeforeDelete - 1);
    }
}
