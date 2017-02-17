package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.repository.PersonneRepository;
import ma.wafa.cream.service.PersonneService;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import ma.wafa.cream.web.rest.mapper.PersonneMapper;

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

import ma.wafa.cream.domain.enumeration.TypePersonne;

/**
 * Test class for the PersonneResource REST controller.
 *
 * @see PersonneResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class PersonneResourceIntTest {

    private static final String DEFAULT_NOM = "AAAAA";
    private static final String UPDATED_NOM = "BBBBB";
    private static final String DEFAULT_NUMERO_CIN = "AAAAA";
    private static final String UPDATED_NUMERO_CIN = "BBBBB";
    private static final String DEFAULT_RC = "AAAAA";
    private static final String UPDATED_RC = "BBBBB";
    private static final String DEFAULT_TELEPHONE = "AAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBB";
    private static final String DEFAULT_PRENOM = "AAAAA";
    private static final String UPDATED_PRENOM = "BBBBB";
    private static final String DEFAULT_CIVILITE = "AAAAA";
    private static final String UPDATED_CIVILITE = "BBBBB";


    private static final TypePersonne DEFAULT_TYPE = TypePersonne.SOCIETE;
    private static final TypePersonne UPDATED_TYPE = TypePersonne.HOMME;
    private static final String DEFAULT_TITRE = "AAAAA";
    private static final String UPDATED_TITRE = "BBBBB";

    private static final LocalDate DEFAULT_DATE_NAISSANCE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_NAISSANCE = LocalDate.now(ZoneId.systemDefault());
    private static final String DEFAULT_NUMERO_PATENTE = "AAAAA";
    private static final String UPDATED_NUMERO_PATENTE = "BBBBB";
    private static final String DEFAULT_RAISON_SOCIALE = "AAAAA";
    private static final String UPDATED_RAISON_SOCIALE = "BBBBB";
    private static final String DEFAULT_EMAIL = "AAAAA";
    private static final String UPDATED_EMAIL = "BBBBB";
    private static final String DEFAULT_VILLE = "AAAAA";
    private static final String UPDATED_VILLE = "BBBBB";

    private static final LocalDate DEFAULT_DATE_OBTENTION_PERMIS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OBTENTION_PERMIS = LocalDate.now(ZoneId.systemDefault());
    private static final String DEFAULT_NUMERO_PERMIS = "AAAAA";
    private static final String UPDATED_NUMERO_PERMIS = "BBBBB";

    @Inject
    private PersonneRepository personneRepository;

    @Inject
    private PersonneMapper personneMapper;

    @Inject
    private PersonneService personneService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restPersonneMockMvc;

    private Personne personne;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PersonneResource personneResource = new PersonneResource();
        ReflectionTestUtils.setField(personneResource, "personneService", personneService);
        ReflectionTestUtils.setField(personneResource, "personneMapper", personneMapper);
        this.restPersonneMockMvc = MockMvcBuilders.standaloneSetup(personneResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        personne = new Personne();
        personne.setNom(DEFAULT_NOM);
        personne.setNumeroCIN(DEFAULT_NUMERO_CIN);
        personne.setRc(DEFAULT_RC);
        personne.setTelephone(DEFAULT_TELEPHONE);
        personne.setPrenom(DEFAULT_PRENOM);
        personne.setCivilite(DEFAULT_CIVILITE);
        personne.setType(DEFAULT_TYPE);
        personne.setTitre(DEFAULT_TITRE);
        personne.setDateNaissance(DEFAULT_DATE_NAISSANCE);
        personne.setNumeroPatente(DEFAULT_NUMERO_PATENTE);
        personne.setRaisonSociale(DEFAULT_RAISON_SOCIALE);
        personne.setEmail(DEFAULT_EMAIL);
        personne.setVille(DEFAULT_VILLE);
        personne.setDateObtentionPermis(DEFAULT_DATE_OBTENTION_PERMIS);
        personne.setNumeroPermis(DEFAULT_NUMERO_PERMIS);
    }

    @Test
    @Transactional
    public void createPersonne() throws Exception {
        int databaseSizeBeforeCreate = personneRepository.findAll().size();

        // Create the Personne
        PersonneDTO personneDTO = personneMapper.personneToPersonneDTO(personne);

        restPersonneMockMvc.perform(post("/api/personnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(personneDTO)))
                .andExpect(status().isCreated());

        // Validate the Personne in the database
        List<Personne> personnes = personneRepository.findAll();
        assertThat(personnes).hasSize(databaseSizeBeforeCreate + 1);
        Personne testPersonne = personnes.get(personnes.size() - 1);
        assertThat(testPersonne.getNom()).isEqualTo(DEFAULT_NOM);
        assertThat(testPersonne.getNumeroCIN()).isEqualTo(DEFAULT_NUMERO_CIN);
        assertThat(testPersonne.getRc()).isEqualTo(DEFAULT_RC);
        assertThat(testPersonne.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testPersonne.getPrenom()).isEqualTo(DEFAULT_PRENOM);
        assertThat(testPersonne.getCivilite()).isEqualTo(DEFAULT_CIVILITE);
        assertThat(testPersonne.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testPersonne.getTitre()).isEqualTo(DEFAULT_TITRE);
        assertThat(testPersonne.getDateNaissance()).isEqualTo(DEFAULT_DATE_NAISSANCE);
        assertThat(testPersonne.getNumeroPatente()).isEqualTo(DEFAULT_NUMERO_PATENTE);
        assertThat(testPersonne.getRaisonSociale()).isEqualTo(DEFAULT_RAISON_SOCIALE);
        assertThat(testPersonne.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testPersonne.getVille()).isEqualTo(DEFAULT_VILLE);
        assertThat(testPersonne.getDateObtentionPermis()).isEqualTo(DEFAULT_DATE_OBTENTION_PERMIS);
        assertThat(testPersonne.getNumeroPermis()).isEqualTo(DEFAULT_NUMERO_PERMIS);
    }

    @Test
    @Transactional
    public void checkNomIsRequired() throws Exception {
        int databaseSizeBeforeTest = personneRepository.findAll().size();
        // set the field null
        personne.setNom(null);

        // Create the Personne, which fails.
        PersonneDTO personneDTO = personneMapper.personneToPersonneDTO(personne);

        restPersonneMockMvc.perform(post("/api/personnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(personneDTO)))
                .andExpect(status().isBadRequest());

        List<Personne> personnes = personneRepository.findAll();
        assertThat(personnes).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPersonnes() throws Exception {
        // Initialize the database
        personneRepository.saveAndFlush(personne);

        // Get all the personnes
        restPersonneMockMvc.perform(get("/api/personnes?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(personne.getId().intValue())))
                .andExpect(jsonPath("$.[*].nom").value(hasItem(DEFAULT_NOM.toString())))
                .andExpect(jsonPath("$.[*].numeroCIN").value(hasItem(DEFAULT_NUMERO_CIN.toString())))
                .andExpect(jsonPath("$.[*].rc").value(hasItem(DEFAULT_RC.toString())))
                .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE.toString())))
                .andExpect(jsonPath("$.[*].prenom").value(hasItem(DEFAULT_PRENOM.toString())))
                .andExpect(jsonPath("$.[*].civilite").value(hasItem(DEFAULT_CIVILITE.toString())))
                .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
                .andExpect(jsonPath("$.[*].titre").value(hasItem(DEFAULT_TITRE.toString())))
                .andExpect(jsonPath("$.[*].dateNaissance").value(hasItem(DEFAULT_DATE_NAISSANCE.toString())))
                .andExpect(jsonPath("$.[*].numeroPatente").value(hasItem(DEFAULT_NUMERO_PATENTE.toString())))
                .andExpect(jsonPath("$.[*].raisonSociale").value(hasItem(DEFAULT_RAISON_SOCIALE.toString())))
                .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
                .andExpect(jsonPath("$.[*].ville").value(hasItem(DEFAULT_VILLE.toString())))
                .andExpect(jsonPath("$.[*].dateObtentionPermis").value(hasItem(DEFAULT_DATE_OBTENTION_PERMIS.toString())))
                .andExpect(jsonPath("$.[*].numeroPermis").value(hasItem(DEFAULT_NUMERO_PERMIS.toString())));
    }

    @Test
    @Transactional
    public void getPersonne() throws Exception {
        // Initialize the database
        personneRepository.saveAndFlush(personne);

        // Get the personne
        restPersonneMockMvc.perform(get("/api/personnes/{id}", personne.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(personne.getId().intValue()))
            .andExpect(jsonPath("$.nom").value(DEFAULT_NOM.toString()))
            .andExpect(jsonPath("$.numeroCIN").value(DEFAULT_NUMERO_CIN.toString()))
            .andExpect(jsonPath("$.rc").value(DEFAULT_RC.toString()))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE.toString()))
            .andExpect(jsonPath("$.prenom").value(DEFAULT_PRENOM.toString()))
            .andExpect(jsonPath("$.civilite").value(DEFAULT_CIVILITE.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.titre").value(DEFAULT_TITRE.toString()))
            .andExpect(jsonPath("$.dateNaissance").value(DEFAULT_DATE_NAISSANCE.toString()))
            .andExpect(jsonPath("$.numeroPatente").value(DEFAULT_NUMERO_PATENTE.toString()))
            .andExpect(jsonPath("$.raisonSociale").value(DEFAULT_RAISON_SOCIALE.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.ville").value(DEFAULT_VILLE.toString()))
            .andExpect(jsonPath("$.dateObtentionPermis").value(DEFAULT_DATE_OBTENTION_PERMIS.toString()))
            .andExpect(jsonPath("$.numeroPermis").value(DEFAULT_NUMERO_PERMIS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingPersonne() throws Exception {
        // Get the personne
        restPersonneMockMvc.perform(get("/api/personnes/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePersonne() throws Exception {
        // Initialize the database
        personneRepository.saveAndFlush(personne);

		int databaseSizeBeforeUpdate = personneRepository.findAll().size();

        // Update the personne
        personne.setNom(UPDATED_NOM);
        personne.setNumeroCIN(UPDATED_NUMERO_CIN);
        personne.setRc(UPDATED_RC);
        personne.setTelephone(UPDATED_TELEPHONE);
        personne.setPrenom(UPDATED_PRENOM);
        personne.setCivilite(UPDATED_CIVILITE);
        personne.setType(UPDATED_TYPE);
        personne.setTitre(UPDATED_TITRE);
        personne.setDateNaissance(UPDATED_DATE_NAISSANCE);
        personne.setNumeroPatente(UPDATED_NUMERO_PATENTE);
        personne.setRaisonSociale(UPDATED_RAISON_SOCIALE);
        personne.setEmail(UPDATED_EMAIL);
        personne.setVille(UPDATED_VILLE);
        personne.setDateObtentionPermis(UPDATED_DATE_OBTENTION_PERMIS);
        personne.setNumeroPermis(UPDATED_NUMERO_PERMIS);
        PersonneDTO personneDTO = personneMapper.personneToPersonneDTO(personne);

        restPersonneMockMvc.perform(put("/api/personnes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(personneDTO)))
                .andExpect(status().isOk());

        // Validate the Personne in the database
        List<Personne> personnes = personneRepository.findAll();
        assertThat(personnes).hasSize(databaseSizeBeforeUpdate);
        Personne testPersonne = personnes.get(personnes.size() - 1);
        assertThat(testPersonne.getNom()).isEqualTo(UPDATED_NOM);
        assertThat(testPersonne.getNumeroCIN()).isEqualTo(UPDATED_NUMERO_CIN);
        assertThat(testPersonne.getRc()).isEqualTo(UPDATED_RC);
        assertThat(testPersonne.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testPersonne.getPrenom()).isEqualTo(UPDATED_PRENOM);
        assertThat(testPersonne.getCivilite()).isEqualTo(UPDATED_CIVILITE);
        assertThat(testPersonne.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testPersonne.getTitre()).isEqualTo(UPDATED_TITRE);
        assertThat(testPersonne.getDateNaissance()).isEqualTo(UPDATED_DATE_NAISSANCE);
        assertThat(testPersonne.getNumeroPatente()).isEqualTo(UPDATED_NUMERO_PATENTE);
        assertThat(testPersonne.getRaisonSociale()).isEqualTo(UPDATED_RAISON_SOCIALE);
        assertThat(testPersonne.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testPersonne.getVille()).isEqualTo(UPDATED_VILLE);
        assertThat(testPersonne.getDateObtentionPermis()).isEqualTo(UPDATED_DATE_OBTENTION_PERMIS);
        assertThat(testPersonne.getNumeroPermis()).isEqualTo(UPDATED_NUMERO_PERMIS);
    }

    @Test
    @Transactional
    public void deletePersonne() throws Exception {
        // Initialize the database
        personneRepository.saveAndFlush(personne);

		int databaseSizeBeforeDelete = personneRepository.findAll().size();

        // Get the personne
        restPersonneMockMvc.perform(delete("/api/personnes/{id}", personne.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Personne> personnes = personneRepository.findAll();
        assertThat(personnes).hasSize(databaseSizeBeforeDelete - 1);
    }
}
