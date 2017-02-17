package ma.wafa.cream.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.RepositoryConstants;
import ma.wafa.cream.repository.TacheRepository;
import ma.wafa.cream.security.SecurityUtils;
import ma.wafa.cream.service.EventService;
import ma.wafa.cream.web.rest.dto.EventDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Action.
 */
@Service
@Transactional
public class EventServiceImpl implements EventService{

    private final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    
    @Inject
    private TacheRepository tacheRepository;

    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;


    /**
     *  get all the actions .
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true) 
    public List<EventDTO> findByUserConnected() {
        log.debug("Request to get all Event for connected user");
        List<EventDTO> eventsDto= new ArrayList<EventDTO>();
        RefStatutTache statutEnCours = refStatutTacheRepository.findByCode(RepositoryConstants.REF_STATUT_TACHE_EN_COURS_CODE);
        
        List<Tache> taches = tacheRepository.findByStatutTacheAndUser(statutEnCours, SecurityUtils.getCurrentUserLogin());
        for (Tache tache : taches) {
    		if (tache.getDateDebut() != null) {
    			EventDTO event = new EventDTO();
				event.setId(tache.getId());
    			event.setStart(tache.getDateDebut());
				event.setEnd(tache.getDateFin());
				event.setTitle(tache.getSujet());
				
				if (tache.getProspection()!=null) {
					event.setUrl("#/prospection/" + tache.getProspection().getId()+"?tacheId=" + tache.getId());
				}
				else {
					event.setUrl("#/tache/" + tache.getId());
				}
				event.setType("Tache");
				eventsDto.add(event);
			}
        	
		}
        
        
        return eventsDto;
    }


	@Override
	public EventDTO update(EventDTO eventDTO) {
		
		System.out.println(eventDTO);
		Tache tache = tacheRepository.findOne(eventDTO.getId());
		
		
		tache.setDateDebut(eventDTO.getStart().plusDays(eventDTO.getDelta()));
		
		tache.setDateFin(eventDTO.getEnd());
		
		tacheRepository.save(tache);
		return eventDTO;
	}


}
