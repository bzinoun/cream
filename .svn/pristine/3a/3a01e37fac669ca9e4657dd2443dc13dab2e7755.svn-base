package ma.wafa.cream.web.rest;

import ma.wafa.cream.Application;
import ma.wafa.cream.domain.Action;
import ma.wafa.cream.repository.ActionRepository;
import ma.wafa.cream.service.ActionService;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;

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

import ma.wafa.cream.domain.enumeration.TypeAction;

/**
 * Test class for the ActionResource REST controller.
 *
 * @see ActionResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ActionResourceIntTest {

    private static final String DEFAULT_SUJET = "AAAAA";
    private static final String UPDATED_SUJET = "BBBBB";
    private static final String DEFAULT_DESCRIPTION = "AAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN = LocalDate.now(ZoneId.systemDefault());


    private static final TypeAction DEFAULT_TYPE_ACTION = TypeAction.APPEL;
    private static final TypeAction UPDATED_TYPE_ACTION = TypeAction.REUNION;
    private static final String DEFAULT_USER = "AAAAA";
    private static final String UPDATED_USER = "BBBBB";

    @Inject
    private ActionRepository actionRepository;

    @Inject
    private ActionMapper actionMapper;

    @Inject
    private ActionService actionService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restActionMockMvc;

    private Action action;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ActionResource actionResource = new ActionResource();
        ReflectionTestUtils.setField(actionResource, "actionService", actionService);
        ReflectionTestUtils.setField(actionResource, "actionMapper", actionMapper);
        this.restActionMockMvc = MockMvcBuilders.standaloneSetup(actionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        action = new Action();
        action.setSujet(DEFAULT_SUJET);
        action.setDescription(DEFAULT_DESCRIPTION);
        action.setDateDebut(DEFAULT_DATE_DEBUT);
        action.setDateFin(DEFAULT_DATE_FIN);
        action.setTypeAction(DEFAULT_TYPE_ACTION);
        action.setUser(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void createAction() throws Exception {
        int databaseSizeBeforeCreate = actionRepository.findAll().size();

        // Create the Action
        ActionDTO actionDTO = actionMapper.actionToActionDTO(action);

        restActionMockMvc.perform(post("/api/actions")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(actionDTO)))
                .andExpect(status().isCreated());

        // Validate the Action in the database
        List<Action> actions = actionRepository.findAll();
        assertThat(actions).hasSize(databaseSizeBeforeCreate + 1);
        Action testAction = actions.get(actions.size() - 1);
        assertThat(testAction.getSujet()).isEqualTo(DEFAULT_SUJET);
        assertThat(testAction.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testAction.getDateDebut()).isEqualTo(DEFAULT_DATE_DEBUT);
        assertThat(testAction.getDateFin()).isEqualTo(DEFAULT_DATE_FIN);
        assertThat(testAction.getTypeAction()).isEqualTo(DEFAULT_TYPE_ACTION);
        assertThat(testAction.getUser()).isEqualTo(DEFAULT_USER);
    }

    @Test
    @Transactional
    public void checkSujetIsRequired() throws Exception {
        int databaseSizeBeforeTest = actionRepository.findAll().size();
        // set the field null
        action.setSujet(null);

        // Create the Action, which fails.
        ActionDTO actionDTO = actionMapper.actionToActionDTO(action);

        restActionMockMvc.perform(post("/api/actions")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(actionDTO)))
                .andExpect(status().isBadRequest());

        List<Action> actions = actionRepository.findAll();
        assertThat(actions).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllActions() throws Exception {
        // Initialize the database
        actionRepository.saveAndFlush(action);

        // Get all the actions
        restActionMockMvc.perform(get("/api/actions?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(action.getId().intValue())))
                .andExpect(jsonPath("$.[*].sujet").value(hasItem(DEFAULT_SUJET.toString())))
                .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
                .andExpect(jsonPath("$.[*].dateDebut").value(hasItem(DEFAULT_DATE_DEBUT.toString())))
                .andExpect(jsonPath("$.[*].dateFin").value(hasItem(DEFAULT_DATE_FIN.toString())))
                .andExpect(jsonPath("$.[*].typeAction").value(hasItem(DEFAULT_TYPE_ACTION.toString())))
                .andExpect(jsonPath("$.[*].user").value(hasItem(DEFAULT_USER.toString())));
    }

    @Test
    @Transactional
    public void getAction() throws Exception {
        // Initialize the database
        actionRepository.saveAndFlush(action);

        // Get the action
        restActionMockMvc.perform(get("/api/actions/{id}", action.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(action.getId().intValue()))
            .andExpect(jsonPath("$.sujet").value(DEFAULT_SUJET.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.dateDebut").value(DEFAULT_DATE_DEBUT.toString()))
            .andExpect(jsonPath("$.dateFin").value(DEFAULT_DATE_FIN.toString()))
            .andExpect(jsonPath("$.typeAction").value(DEFAULT_TYPE_ACTION.toString()))
            .andExpect(jsonPath("$.user").value(DEFAULT_USER.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAction() throws Exception {
        // Get the action
        restActionMockMvc.perform(get("/api/actions/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAction() throws Exception {
        // Initialize the database
        actionRepository.saveAndFlush(action);

		int databaseSizeBeforeUpdate = actionRepository.findAll().size();

        // Update the action
        action.setSujet(UPDATED_SUJET);
        action.setDescription(UPDATED_DESCRIPTION);
        action.setDateDebut(UPDATED_DATE_DEBUT);
        action.setDateFin(UPDATED_DATE_FIN);
        action.setTypeAction(UPDATED_TYPE_ACTION);
        action.setUser(UPDATED_USER);
        ActionDTO actionDTO = actionMapper.actionToActionDTO(action);

        restActionMockMvc.perform(put("/api/actions")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(actionDTO)))
                .andExpect(status().isOk());

        // Validate the Action in the database
        List<Action> actions = actionRepository.findAll();
        assertThat(actions).hasSize(databaseSizeBeforeUpdate);
        Action testAction = actions.get(actions.size() - 1);
        assertThat(testAction.getSujet()).isEqualTo(UPDATED_SUJET);
        assertThat(testAction.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testAction.getDateDebut()).isEqualTo(UPDATED_DATE_DEBUT);
        assertThat(testAction.getDateFin()).isEqualTo(UPDATED_DATE_FIN);
        assertThat(testAction.getTypeAction()).isEqualTo(UPDATED_TYPE_ACTION);
        assertThat(testAction.getUser()).isEqualTo(UPDATED_USER);
    }

    @Test
    @Transactional
    public void deleteAction() throws Exception {
        // Initialize the database
        actionRepository.saveAndFlush(action);

		int databaseSizeBeforeDelete = actionRepository.findAll().size();

        // Get the action
        restActionMockMvc.perform(delete("/api/actions/{id}", action.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Action> actions = actionRepository.findAll();
        assertThat(actions).hasSize(databaseSizeBeforeDelete - 1);
    }
}
