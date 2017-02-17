package ma.wafa.cream.service.impl;

import ma.wafa.cream.security.SecurityUtils;
import ma.wafa.cream.service.TacheService;
import ma.wafa.cream.domain.Action;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.repository.ActionRepository;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.RepositoryConstants;
import ma.wafa.cream.repository.TacheRepository;
import ma.wafa.cream.repository.search.TacheSearchRepository;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.dto.TacheDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;
import ma.wafa.cream.web.rest.mapper.TacheMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Tache.
 */
@Service
@Transactional
public class TacheServiceImpl implements TacheService{

    private final Logger log = LoggerFactory.getLogger(TacheServiceImpl.class);
    
    @Inject
    private TacheRepository tacheRepository;

    @Inject
    private ActionRepository actionRepository;
    
    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;
    
    @Inject
    private TacheMapper tacheMapper;
    @Inject
    private ActionMapper actionMapper;
    
    @Inject
    private TacheSearchRepository tacheSearchRepository;
    
    /**
     * Save a tache.
     * @return the persisted entity
     */
    public TacheDTO save(TacheDTO tacheDTO) {
        log.debug("Request to save Tache : {}", tacheDTO);
        
        
        if (tacheDTO.getUser() == null || tacheDTO.getUser().isEmpty() ) {
			tacheDTO.setUser(SecurityUtils.getCurrentUserLogin());
		}
		Tache tache = tacheMapper.tacheDTOToTache(tacheDTO);
        tache = tacheRepository.save(tache);
        TacheDTO result = tacheMapper.tacheToTacheDTO(tache);
        tacheSearchRepository.save(tache);
        return result;
    }

    /**
     *  get all the taches.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Tache> findAll(Pageable pageable) {
        log.debug("Request to get all Taches");
        Page<Tache> result = tacheRepository.findAll(pageable); 
        return result;
    }
    /**
     *  get all the taches for connected user.
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true) 
    public Page<Tache> findByUserConnected(Pageable pageable) {
    	log.debug("Request to get all Taches for connected user");
    	Page<Tache> result = tacheRepository.findByUser(SecurityUtils.getCurrentUserLogin(), pageable); 
    	return result;
    }

    /**
     *  get one tache by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public TacheDTO findOne(Long id) {
        log.debug("Request to get Tache : {}", id);
        Tache tache = tacheRepository.findOne(id);
        TacheDTO tacheDTO = tacheMapper.tacheToTacheDTO(tache);
        return tacheDTO;
    }

    /**
     *  delete the  tache by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Tache : {}", id);
        tacheRepository.delete(id);
        tacheSearchRepository.delete(id);
    }

    /**
     * search for the tache corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<TacheDTO> search(String query) {
        
        log.debug("REST request to search Taches for query {}", query);
        return StreamSupport
            .stream(tacheSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(tacheMapper::tacheToTacheDTO)
            .collect(Collectors.toList());
    }

	@Override
	public List<ActionDTO> findActions(Long id) {
		Tache tache = tacheRepository.findOne(id);

		Set<ActionDTO> actionsDTO = actionMapper.mapActionsToActionDTOs(tache.getActions());

		return new ArrayList<ActionDTO>(actionsDTO);
	}

	@Override
	public Page<Tache> findLastNbrTache(int nbr) {
		
		Pageable top = new PageRequest(0, nbr , Direction.ASC  ,"dateFin" ); 
		String currentUserLogin = SecurityUtils.getCurrentUserLogin();
//		REF_STATUT_PROSPECTION_EN_COURS_CODE
		RefStatutTache encours = refStatutTacheRepository.findByCode(RepositoryConstants.REF_STATUT_TACHE_EN_COURS_CODE);
		Page<Tache> Taches = tacheRepository.findByStatutTacheAndUser(encours , currentUserLogin, top);
		
		return Taches;
	}
	@Override
	public List<TacheDTO> findByStatutTacheAndUserAndProspection(RefStatutTache refStatutTache, Prospection prospection) {
		
		String currentUserLogin = SecurityUtils.getCurrentUserLogin();
		List<Tache> Taches = tacheRepository.findByStatutTacheAndUserAndProspection(refStatutTache, currentUserLogin, prospection);
		
		List<TacheDTO> tachesDtos = tacheMapper.tachesToTacheDTOs(Taches);
		return tachesDtos;
	}

	@Override
	public List<TacheDTO> findAPlanifier() {
		String currentUserLogin = SecurityUtils.getCurrentUserLogin();
		
		TacheRepository tache = tacheRepository;
		List<Tache> listeTache = tache.findByStatutTacheCodeAndUser(RepositoryConstants.REF_STATUT_TACHE_NON_COMMENCE_CODE, currentUserLogin);
		List<TacheDTO> listeTacheDto = tacheMapper.tachesToTacheDTOs(listeTache);
		return listeTacheDto;
	}
}
