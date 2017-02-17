package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.RefSituationFamiliale;
import ma.wafa.cream.repository.RefSituationFamilialeRepository;
import ma.wafa.cream.repository.search.RefSituationFamilialeSearchRepository;
import ma.wafa.cream.web.rest.dto.RefSituationFamilialeDTO;
import ma.wafa.cream.web.rest.mapper.RefSituationFamilialeMapper;

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
 * Test class for the RefSituationFamilialeResource REST controller.
 *
 * @see RefSituationFamilialeResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RefSituationFamilialeResourceIntTest {

    private static final String DEFAULT_CODE = "AAAAA";
    private static final String UPDATED_CODE = "BBBBB";
    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    @Inject
    private RefSituationFamilialeRepository refSituationFamilialeRepository;

    @Inject
    private RefSituationFamilialeMapper refSituationFamilialeMapper;

    @Inject
    private RefSituationFamilialeSearchRepository refSituationFamilialeSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restRefSituationFamilialeMockMvc;

    private RefSituationFamiliale refSituationFamiliale;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RefSituationFamilialeResource refSituationFamilialeResource = new RefSituationFamilialeResource();
        ReflectionTestUtils.setField(refSituationFamilialeResource, "refSituationFamilialeSearchRepository", refSituationFamilialeSearchRepository);
        ReflectionTestUtils.setField(refSituationFamilialeResource, "refSituationFamilialeRepository", refSituationFamilialeRepository);
        ReflectionTestUtils.setField(refSituationFamilialeResource, "refSituationFamilialeMapper", refSituationFamilialeMapper);
        this.restRefSituationFamilialeMockMvc = MockMvcBuilders.standaloneSetup(refSituationFamilialeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        refSituationFamiliale = new RefSituationFamiliale();
        refSituationFamiliale.setCode(DEFAULT_CODE);
        refSituationFamiliale.setLibelle(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createRefSituationFamiliale() throws Exception {
        int databaseSizeBeforeCreate = refSituationFamilialeRepository.findAll().size();

        // Create the RefSituationFamiliale
        RefSituationFamilialeDTO refSituationFamilialeDTO = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);

        restRefSituationFamilialeMockMvc.perform(post("/api/refSituationFamiliales")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSituationFamilialeDTO)))
                .andExpect(status().isCreated());

        // Validate the RefSituationFamiliale in the database
        List<RefSituationFamiliale> refSituationFamiliales = refSituationFamilialeRepository.findAll();
        assertThat(refSituationFamiliales).hasSize(databaseSizeBeforeCreate + 1);
        RefSituationFamiliale testRefSituationFamiliale = refSituationFamiliales.get(refSituationFamiliales.size() - 1);
        assertThat(testRefSituationFamiliale.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRefSituationFamiliale.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = refSituationFamilialeRepository.findAll().size();
        // set the field null
        refSituationFamiliale.setCode(null);

        // Create the RefSituationFamiliale, which fails.
        RefSituationFamilialeDTO refSituationFamilialeDTO = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);

        restRefSituationFamilialeMockMvc.perform(post("/api/refSituationFamiliales")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSituationFamilialeDTO)))
                .andExpect(status().isBadRequest());

        List<RefSituationFamiliale> refSituationFamiliales = refSituationFamilialeRepository.findAll();
        assertThat(refSituationFamiliales).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = refSituationFamilialeRepository.findAll().size();
        // set the field null
        refSituationFamiliale.setLibelle(null);

        // Create the RefSituationFamiliale, which fails.
        RefSituationFamilialeDTO refSituationFamilialeDTO = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);

        restRefSituationFamilialeMockMvc.perform(post("/api/refSituationFamiliales")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSituationFamilialeDTO)))
                .andExpect(status().isBadRequest());

        List<RefSituationFamiliale> refSituationFamiliales = refSituationFamilialeRepository.findAll();
        assertThat(refSituationFamiliales).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRefSituationFamiliales() throws Exception {
        // Initialize the database
        refSituationFamilialeRepository.saveAndFlush(refSituationFamiliale);

        // Get all the refSituationFamiliales
        restRefSituationFamilialeMockMvc.perform(get("/api/refSituationFamiliales?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(refSituationFamiliale.getId().intValue())))
                .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())));
    }

    @Test
    @Transactional
    public void getRefSituationFamiliale() throws Exception {
        // Initialize the database
        refSituationFamilialeRepository.saveAndFlush(refSituationFamiliale);

        // Get the refSituationFamiliale
        restRefSituationFamilialeMockMvc.perform(get("/api/refSituationFamiliales/{id}", refSituationFamiliale.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(refSituationFamiliale.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRefSituationFamiliale() throws Exception {
        // Get the refSituationFamiliale
        restRefSituationFamilialeMockMvc.perform(get("/api/refSituationFamiliales/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRefSituationFamiliale() throws Exception {
        // Initialize the database
        refSituationFamilialeRepository.saveAndFlush(refSituationFamiliale);

		int databaseSizeBeforeUpdate = refSituationFamilialeRepository.findAll().size();

        // Update the refSituationFamiliale
        refSituationFamiliale.setCode(UPDATED_CODE);
        refSituationFamiliale.setLibelle(UPDATED_LIBELLE);
        RefSituationFamilialeDTO refSituationFamilialeDTO = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);

        restRefSituationFamilialeMockMvc.perform(put("/api/refSituationFamiliales")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSituationFamilialeDTO)))
                .andExpect(status().isOk());

        // Validate the RefSituationFamiliale in the database
        List<RefSituationFamiliale> refSituationFamiliales = refSituationFamilialeRepository.findAll();
        assertThat(refSituationFamiliales).hasSize(databaseSizeBeforeUpdate);
        RefSituationFamiliale testRefSituationFamiliale = refSituationFamiliales.get(refSituationFamiliales.size() - 1);
        assertThat(testRefSituationFamiliale.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRefSituationFamiliale.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void deleteRefSituationFamiliale() throws Exception {
        // Initialize the database
        refSituationFamilialeRepository.saveAndFlush(refSituationFamiliale);

		int databaseSizeBeforeDelete = refSituationFamilialeRepository.findAll().size();

        // Get the refSituationFamiliale
        restRefSituationFamilialeMockMvc.perform(delete("/api/refSituationFamiliales/{id}", refSituationFamiliale.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<RefSituationFamiliale> refSituationFamiliales = refSituationFamilialeRepository.findAll();
        assertThat(refSituationFamiliales).hasSize(databaseSizeBeforeDelete - 1);
    }
}
