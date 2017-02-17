package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.RefStatutCompagne;
import ma.wafa.cream.repository.RefStatutCompagneRepository;
import ma.wafa.cream.repository.search.RefStatutCompagneSearchRepository;
import ma.wafa.cream.web.rest.dto.RefStatutCompagneDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutCompagneMapper;

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
 * Test class for the RefStatutCompagneResource REST controller.
 *
 * @see RefStatutCompagneResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RefStatutCompagneResourceIntTest {

    private static final String DEFAULT_CODE = "AAAAA";
    private static final String UPDATED_CODE = "BBBBB";
    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    @Inject
    private RefStatutCompagneRepository refStatutCompagneRepository;

    @Inject
    private RefStatutCompagneMapper refStatutCompagneMapper;

    @Inject
    private RefStatutCompagneSearchRepository refStatutCompagneSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restRefStatutCompagneMockMvc;

    private RefStatutCompagne refStatutCompagne;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RefStatutCompagneResource refStatutCompagneResource = new RefStatutCompagneResource();
        ReflectionTestUtils.setField(refStatutCompagneResource, "refStatutCompagneSearchRepository", refStatutCompagneSearchRepository);
        ReflectionTestUtils.setField(refStatutCompagneResource, "refStatutCompagneRepository", refStatutCompagneRepository);
        ReflectionTestUtils.setField(refStatutCompagneResource, "refStatutCompagneMapper", refStatutCompagneMapper);
        this.restRefStatutCompagneMockMvc = MockMvcBuilders.standaloneSetup(refStatutCompagneResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        refStatutCompagne = new RefStatutCompagne();
        refStatutCompagne.setCode(DEFAULT_CODE);
        refStatutCompagne.setLibelle(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createRefStatutCompagne() throws Exception {
        int databaseSizeBeforeCreate = refStatutCompagneRepository.findAll().size();

        // Create the RefStatutCompagne
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);

        restRefStatutCompagneMockMvc.perform(post("/api/refStatutCompagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutCompagneDTO)))
                .andExpect(status().isCreated());

        // Validate the RefStatutCompagne in the database
        List<RefStatutCompagne> refStatutCompagnes = refStatutCompagneRepository.findAll();
        assertThat(refStatutCompagnes).hasSize(databaseSizeBeforeCreate + 1);
        RefStatutCompagne testRefStatutCompagne = refStatutCompagnes.get(refStatutCompagnes.size() - 1);
        assertThat(testRefStatutCompagne.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRefStatutCompagne.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutCompagneRepository.findAll().size();
        // set the field null
        refStatutCompagne.setCode(null);

        // Create the RefStatutCompagne, which fails.
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);

        restRefStatutCompagneMockMvc.perform(post("/api/refStatutCompagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutCompagneDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutCompagne> refStatutCompagnes = refStatutCompagneRepository.findAll();
        assertThat(refStatutCompagnes).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = refStatutCompagneRepository.findAll().size();
        // set the field null
        refStatutCompagne.setLibelle(null);

        // Create the RefStatutCompagne, which fails.
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);

        restRefStatutCompagneMockMvc.perform(post("/api/refStatutCompagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutCompagneDTO)))
                .andExpect(status().isBadRequest());

        List<RefStatutCompagne> refStatutCompagnes = refStatutCompagneRepository.findAll();
        assertThat(refStatutCompagnes).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRefStatutCompagnes() throws Exception {
        // Initialize the database
        refStatutCompagneRepository.saveAndFlush(refStatutCompagne);

        // Get all the refStatutCompagnes
        restRefStatutCompagneMockMvc.perform(get("/api/refStatutCompagnes?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(refStatutCompagne.getId().intValue())))
                .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())));
    }

    @Test
    @Transactional
    public void getRefStatutCompagne() throws Exception {
        // Initialize the database
        refStatutCompagneRepository.saveAndFlush(refStatutCompagne);

        // Get the refStatutCompagne
        restRefStatutCompagneMockMvc.perform(get("/api/refStatutCompagnes/{id}", refStatutCompagne.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(refStatutCompagne.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRefStatutCompagne() throws Exception {
        // Get the refStatutCompagne
        restRefStatutCompagneMockMvc.perform(get("/api/refStatutCompagnes/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRefStatutCompagne() throws Exception {
        // Initialize the database
        refStatutCompagneRepository.saveAndFlush(refStatutCompagne);

		int databaseSizeBeforeUpdate = refStatutCompagneRepository.findAll().size();

        // Update the refStatutCompagne
        refStatutCompagne.setCode(UPDATED_CODE);
        refStatutCompagne.setLibelle(UPDATED_LIBELLE);
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);

        restRefStatutCompagneMockMvc.perform(put("/api/refStatutCompagnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refStatutCompagneDTO)))
                .andExpect(status().isOk());

        // Validate the RefStatutCompagne in the database
        List<RefStatutCompagne> refStatutCompagnes = refStatutCompagneRepository.findAll();
        assertThat(refStatutCompagnes).hasSize(databaseSizeBeforeUpdate);
        RefStatutCompagne testRefStatutCompagne = refStatutCompagnes.get(refStatutCompagnes.size() - 1);
        assertThat(testRefStatutCompagne.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRefStatutCompagne.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void deleteRefStatutCompagne() throws Exception {
        // Initialize the database
        refStatutCompagneRepository.saveAndFlush(refStatutCompagne);

		int databaseSizeBeforeDelete = refStatutCompagneRepository.findAll().size();

        // Get the refStatutCompagne
        restRefStatutCompagneMockMvc.perform(delete("/api/refStatutCompagnes/{id}", refStatutCompagne.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<RefStatutCompagne> refStatutCompagnes = refStatutCompagneRepository.findAll();
        assertThat(refStatutCompagnes).hasSize(databaseSizeBeforeDelete - 1);
    }
}
