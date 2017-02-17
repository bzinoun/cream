package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.search.RefStatutTacheSearchRepository;
import ma.wafa.cream.web.rest.dto.RefStatutTacheDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutTacheMapper;

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
 * Test class for the RefStatutTacheResource REST controller.
 *
 * @see RefStatutTacheResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RefStatutTacheResourceIntTest {

    private static final String DEFAULT_CODE = "AAAAA";
    private static final String UPDATED_CODE = "BBBBB";
    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;

    @Inject
    private RefStatutTacheMapper refStatutTacheMapper;

    @Inject
    private RefStatutTacheSearchRepository refStatutTacheSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restRefStatutTacheMockMvc;

    private RefStatutTache refStatutTache;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RefStatutTacheResource refStatutTacheResource = new RefStatutTacheResource();
        ReflectionTestUtils.setField(refStatutTacheResource, "refStatutTacheSearchRepository", refStatutTacheSearchRepository);
        ReflectionTestUtils.setField(refStatutTacheResource, "refStatutTacheRepository", refStatutTacheRepository);
        ReflectionTestUtils.setField(refStatutTacheResource, "refStatutTacheMapper", refStatutTacheMapper);
        this.restRefStatutTacheMockMvc = MockMvcBuilders.standaloneSetup(refStatutTacheResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        refStatutTache = new RefStatutTache();
        refStatutTache.setCode(DEFAULT_CODE);
        refStatutTache.setLibelle(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createRefStatutTache() throws Exception {
        int databaseSizeBeforeCreate = refStatutTacheRepository.findAll().size();

        // Create the RefStatutTache
        RefStatutTacheDTO refStatutTacheDTO = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);

        restRefStatutTacheMockMvc.perform(post("/api/refStatutTaches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutTacheDTO)))
                .andExpect(status().isCreated());

        // Validate the RefStatutTache in the database
        List<RefStatutTache> refStatutTaches = refStatutTacheRepository.findAll();
        assertThat(refStatutTaches).hasSize(databaseSizeBeforeCreate + 1);
        RefStatutTache testRefStatutTache = refStatutTaches.get(refStatutTaches.size() - 1);
        assertThat(testRefStatutTache.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRefStatutTache.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutTacheRepository.findAll().size();
        // set the field null
        refStatutTache.setCode(null);

        // Create the RefStatutTache, which fails.
        RefStatutTacheDTO refStatutTacheDTO = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);

        restRefStatutTacheMockMvc.perform(post("/api/refStatutTaches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutTacheDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutTache> refStatutTaches = refStatutTacheRepository.findAll();
        assertThat(refStatutTaches).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutTacheRepository.findAll().size();
        // set the field null
        refStatutTache.setLibelle(null);

        // Create the RefStatutTache, which fails.
        RefStatutTacheDTO refStatutTacheDTO = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);

        restRefStatutTacheMockMvc.perform(post("/api/refStatutTaches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutTacheDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutTache> refStatutTaches = refStatutTacheRepository.findAll();
        assertThat(refStatutTaches).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRefStatutTaches() throws Exception {
        // Initialize the database
        refStatutTacheRepository.saveAndFlush(refStatutTache);

        // Get all the refStatutTaches
        restRefStatutTacheMockMvc.perform(get("/api/refStatutTaches?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(refStatutTache.getId().intValue())))
                .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())));
    }

    @Test
    @Transactional
    public void getRefStatutTache() throws Exception {
        // Initialize the database
        refStatutTacheRepository.saveAndFlush(refStatutTache);

        // Get the refStatutTache
        restRefStatutTacheMockMvc.perform(get("/api/refStatutTaches/{id}", refStatutTache.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(refStatutTache.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRefStatutTache() throws Exception {
        // Get the refStatutTache
        restRefStatutTacheMockMvc.perform(get("/api/refStatutTaches/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRefStatutTache() throws Exception {
        // Initialize the database
        refStatutTacheRepository.saveAndFlush(refStatutTache);

		int databaseSizeBeforeUpdate = refStatutTacheRepository.findAll().size();

        // Update the refStatutTache
        refStatutTache.setCode(UPDATED_CODE);
        refStatutTache.setLibelle(UPDATED_LIBELLE);
        RefStatutTacheDTO refStatutTacheDTO = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);

        restRefStatutTacheMockMvc.perform(put("/api/refStatutTaches")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutTacheDTO)))
                .andExpect(status().isOk());

        // Validate the RefStatutTache in the database
        List<RefStatutTache> refStatutTaches = refStatutTacheRepository.findAll();
        assertThat(refStatutTaches).hasSize(databaseSizeBeforeUpdate);
        RefStatutTache testRefStatutTache = refStatutTaches.get(refStatutTaches.size() - 1);
        assertThat(testRefStatutTache.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRefStatutTache.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void deleteRefStatutTache() throws Exception {
        // Initialize the database
        refStatutTacheRepository.saveAndFlush(refStatutTache);

		int databaseSizeBeforeDelete = refStatutTacheRepository.findAll().size();

        // Get the refStatutTache
        restRefStatutTacheMockMvc.perform(delete("/api/refStatutTaches/{id}", refStatutTache.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<RefStatutTache> refStatutTaches = refStatutTacheRepository.findAll();
        assertThat(refStatutTaches).hasSize(databaseSizeBeforeDelete - 1);
    }
}
