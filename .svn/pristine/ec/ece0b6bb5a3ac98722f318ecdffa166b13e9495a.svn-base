package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.RefSecteurActivite;
import ma.wafa.cream.repository.RefSecteurActiviteRepository;
import ma.wafa.cream.repository.search.RefSecteurActiviteSearchRepository;
import ma.wafa.cream.web.rest.dto.RefSecteurActiviteDTO;
import ma.wafa.cream.web.rest.mapper.RefSecteurActiviteMapper;

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
 * Test class for the RefSecteurActiviteResource REST controller.
 *
 * @see RefSecteurActiviteResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class RefSecteurActiviteResourceIntTest {

    private static final String DEFAULT_CODE = "AAAAA";
    private static final String UPDATED_CODE = "BBBBB";
    private static final String DEFAULT_LIBELLE = "AAAAA";
    private static final String UPDATED_LIBELLE = "BBBBB";

    @Inject
    private RefSecteurActiviteRepository refSecteurActiviteRepository;

    @Inject
    private RefSecteurActiviteMapper refSecteurActiviteMapper;

    @Inject
    private RefSecteurActiviteSearchRepository refSecteurActiviteSearchRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restRefSecteurActiviteMockMvc;

    private RefSecteurActivite refSecteurActivite;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RefSecteurActiviteResource refSecteurActiviteResource = new RefSecteurActiviteResource();
        ReflectionTestUtils.setField(refSecteurActiviteResource, "refSecteurActiviteSearchRepository", refSecteurActiviteSearchRepository);
        ReflectionTestUtils.setField(refSecteurActiviteResource, "refSecteurActiviteRepository", refSecteurActiviteRepository);
        ReflectionTestUtils.setField(refSecteurActiviteResource, "refSecteurActiviteMapper", refSecteurActiviteMapper);
        this.restRefSecteurActiviteMockMvc = MockMvcBuilders.standaloneSetup(refSecteurActiviteResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        refSecteurActivite = new RefSecteurActivite();
        refSecteurActivite.setCode(DEFAULT_CODE);
        refSecteurActivite.setLibelle(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createRefSecteurActivite() throws Exception {
        int databaseSizeBeforeCreate = refSecteurActiviteRepository.findAll().size();

        // Create the RefSecteurActivite
        RefSecteurActiviteDTO refSecteurActiviteDTO = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);

        restRefSecteurActiviteMockMvc.perform(post("/api/refSecteurActivites")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSecteurActiviteDTO)))
                .andExpect(status().isCreated());

        // Validate the RefSecteurActivite in the database
        List<RefSecteurActivite> refSecteurActivites = refSecteurActiviteRepository.findAll();
        assertThat(refSecteurActivites).hasSize(databaseSizeBeforeCreate + 1);
        RefSecteurActivite testRefSecteurActivite = refSecteurActivites.get(refSecteurActivites.size() - 1);
        assertThat(testRefSecteurActivite.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testRefSecteurActivite.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = refSecteurActiviteRepository.findAll().size();
        // set the field null
        refSecteurActivite.setCode(null);

        // Create the RefSecteurActivite, which fails.
        RefSecteurActiviteDTO refSecteurActiviteDTO = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);

        restRefSecteurActiviteMockMvc.perform(post("/api/refSecteurActivites")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSecteurActiviteDTO)))
                .andExpect(status().isBadRequest());

        List<RefSecteurActivite> refSecteurActivites = refSecteurActiviteRepository.findAll();
        assertThat(refSecteurActivites).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLibelleIsRequired() throws Exception {
        int databaseSizeBeforeTest = refSecteurActiviteRepository.findAll().size();
        // set the field null
        refSecteurActivite.setLibelle(null);

        // Create the RefSecteurActivite, which fails.
        RefSecteurActiviteDTO refSecteurActiviteDTO = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);

        restRefSecteurActiviteMockMvc.perform(post("/api/refSecteurActivites")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSecteurActiviteDTO)))
                .andExpect(status().isBadRequest());

        List<RefSecteurActivite> refSecteurActivites = refSecteurActiviteRepository.findAll();
        assertThat(refSecteurActivites).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRefSecteurActivites() throws Exception {
        // Initialize the database
        refSecteurActiviteRepository.saveAndFlush(refSecteurActivite);

        // Get all the refSecteurActivites
        restRefSecteurActiviteMockMvc.perform(get("/api/refSecteurActivites?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(refSecteurActivite.getId().intValue())))
                .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
                .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE.toString())));
    }

    @Test
    @Transactional
    public void getRefSecteurActivite() throws Exception {
        // Initialize the database
        refSecteurActiviteRepository.saveAndFlush(refSecteurActivite);

        // Get the refSecteurActivite
        restRefSecteurActiviteMockMvc.perform(get("/api/refSecteurActivites/{id}", refSecteurActivite.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(refSecteurActivite.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRefSecteurActivite() throws Exception {
        // Get the refSecteurActivite
        restRefSecteurActiviteMockMvc.perform(get("/api/refSecteurActivites/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRefSecteurActivite() throws Exception {
        // Initialize the database
        refSecteurActiviteRepository.saveAndFlush(refSecteurActivite);

		int databaseSizeBeforeUpdate = refSecteurActiviteRepository.findAll().size();

        // Update the refSecteurActivite
        refSecteurActivite.setCode(UPDATED_CODE);
        refSecteurActivite.setLibelle(UPDATED_LIBELLE);
        RefSecteurActiviteDTO refSecteurActiviteDTO = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);

        restRefSecteurActiviteMockMvc.perform(put("/api/refSecteurActivites")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(refSecteurActiviteDTO)))
                .andExpect(status().isOk());

        // Validate the RefSecteurActivite in the database
        List<RefSecteurActivite> refSecteurActivites = refSecteurActiviteRepository.findAll();
        assertThat(refSecteurActivites).hasSize(databaseSizeBeforeUpdate);
        RefSecteurActivite testRefSecteurActivite = refSecteurActivites.get(refSecteurActivites.size() - 1);
        assertThat(testRefSecteurActivite.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testRefSecteurActivite.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void deleteRefSecteurActivite() throws Exception {
        // Initialize the database
        refSecteurActiviteRepository.saveAndFlush(refSecteurActivite);

		int databaseSizeBeforeDelete = refSecteurActiviteRepository.findAll().size();

        // Get the refSecteurActivite
        restRefSecteurActiviteMockMvc.perform(delete("/api/refSecteurActivites/{id}", refSecteurActivite.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<RefSecteurActivite> refSecteurActivites = refSecteurActiviteRepository.findAll();
        assertThat(refSecteurActivites).hasSize(databaseSizeBeforeDelete - 1);
    }
}
