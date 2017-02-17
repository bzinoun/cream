package ma.wafa.cream.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;

import ma.wafa.cream.domain.Action;
import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.domain.enumeration.TypeAction;
import ma.wafa.cream.domain.enumeration.TypeTache;
import ma.wafa.cream.repository.ActionRepository;
import ma.wafa.cream.repository.ProspectionRepository;
import ma.wafa.cream.repository.RefStatutProspectionRepository;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.RepositoryConstants;
import ma.wafa.cream.repository.search.ActionSearchRepository;
import ma.wafa.cream.security.SecurityUtils;
import ma.wafa.cream.service.ActionService;
import ma.wafa.cream.service.TacheService;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.dto.TacheDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Action.
 */
@Service
@Transactional
public class ActionServiceImpl implements ActionService {

	private final Logger log = LoggerFactory.getLogger(ActionServiceImpl.class);

	@Inject
	private ActionRepository actionRepository;
	@Inject
	private RefStatutTacheRepository refStatutTacheRepository;
	@Inject
	private ProspectionRepository prospectionRepository;
	@Inject
	private RefStatutProspectionRepository refStatutProspectionRepository;

	@Inject
	private ActionMapper actionMapper;

	@Inject
	private TacheService tacheService;
	@Inject
	private ActionSearchRepository actionSearchRepository;

	/**
	 * Save a action.
	 * 
	 * @return the persisted entity
	 */
	public ActionDTO save(ActionDTO actionDTO) {
		log.debug("Request to save Action : {}", actionDTO);
		if (actionDTO.getUser() == null || actionDTO.getUser().isEmpty()) {
			actionDTO.setUser(SecurityUtils.getCurrentUserLogin());
		}

		RefStatutTache statutEnCours = refStatutTacheRepository
				.findByCode(RepositoryConstants.REF_STATUT_TACHE_EN_COURS_CODE);
		RefStatutTache statutEnTermine = refStatutTacheRepository
				.findByCode(RepositoryConstants.REF_STATUT_TACHE_TERMINE_CODE);
		// action creer depuis la vue 360
		if (actionDTO.getTacheId() == null) {

			List<TacheDTO> listTacheEncours = tacheService
					.findByStatutTacheAndUserAndProspection(statutEnCours,
							prospectionRepository.findOne(actionDTO
									.get_prospectionId()));

			if (listTacheEncours != null && !listTacheEncours.isEmpty()) {
				TacheDTO tacheDTO = listTacheEncours.get(0);
				actionDTO.setTacheId(tacheDTO.getId());
			} else {
				TacheDTO tacheDto = new TacheDTO();
				tacheDto.setDateDebut(actionDTO.getDateDebut());
				tacheDto.setSujet(actionDTO.getSujet());
				tacheDto.setProspectionId(actionDTO.get_prospectionId());
				tacheDto.setType(TypeTache.SYSTEM);
				tacheDto.setStatutTacheId(statutEnTermine.getId());
				TacheDTO tacheDtoSaved = tacheService.save(tacheDto);
				actionDTO.setTacheId(tacheDtoSaved.getId());
			}

		}

		if (TypeAction.CONCRETISATION.equals(actionDTO.getTypeAction())) {
			cloturerProspect(actionDTO, statutEnTermine , Boolean.TRUE);
		}
		
		if (TypeAction.ABANDONNER.equals(actionDTO.getTypeAction())) {
			cloturerProspect(actionDTO, statutEnTermine,Boolean.FALSE);
		}

		Action action = actionMapper.actionDTOToAction(actionDTO);
		action = actionRepository.save(action);
		ActionDTO result = actionMapper.actionToActionDTO(action);
		actionSearchRepository.save(action);
		return result;
	}

	private void cloturerProspect(ActionDTO actionDTO,
			RefStatutTache statutEnTermine , Boolean isClient) {
		Prospection prospection = prospectionRepository.findOne(actionDTO
				.get_prospectionId());
		prospection
				.setStatutProspection(refStatutProspectionRepository
						.findByCode(RepositoryConstants.REF_STATUT_PROSPECTION_TERMINE_CODE));

		prospectionRepository.save(prospection);

		Personne personne = prospection.getPersonne();
		personne.setClient(isClient);
		personne.setNumeroContrat(actionDTO.get_numeroContrat());

		
		for (Tache tache : prospection.getTaches()) {

			tache.setStatutTache(statutEnTermine);
		}

		
		prospectionRepository.save(prospection);
	}

	/**
	 * get all the actions for connected user.
	 * 
	 * @return the list of entities
	 */
	@Transactional(readOnly = true)
	public Page<Action> findAll(Pageable pageable) {
		log.debug("Request to get all Actions");
		Page<Action> result = actionRepository.findAll(pageable);
		return result;
	}

	/**
	 * get all the actions .
	 * 
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Action> findByUserConnected(Pageable pageable) {
		log.debug("Request to get all Actions for connected user");
		Page<Action> result = actionRepository.findByUser(
				SecurityUtils.getCurrentUserLogin(), pageable);
		return result;
	}

	/**
	 * get one action by id.
	 * 
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public ActionDTO findOne(Long id) {
		log.debug("Request to get Action : {}", id);
		Action action = actionRepository.findOne(id);
		ActionDTO actionDTO = actionMapper.actionToActionDTO(action);
		return actionDTO;
	}

	/**
	 * delete the action by id.
	 */
	public void delete(Long id) {
		log.debug("Request to delete Action : {}", id);
		actionRepository.delete(id);
		actionSearchRepository.delete(id);
	}

	/**
	 * search for the action corresponding to the query.
	 */
	@Transactional(readOnly = true)
	public List<ActionDTO> search(String query) {

		log.debug("REST request to search Actions for query {}", query);
		return StreamSupport
				.stream(actionSearchRepository.search(queryStringQuery(query))
						.spliterator(), false)
				.map(actionMapper::actionToActionDTO)
				.collect(Collectors.toList());
	}
}
