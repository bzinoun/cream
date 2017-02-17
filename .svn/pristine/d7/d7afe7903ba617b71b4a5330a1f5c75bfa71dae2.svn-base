package ma.wafa.cream.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutProspection;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.repository.ProspectionRepository;
import ma.wafa.cream.repository.RefStatutProspectionRepository;
import ma.wafa.cream.repository.RepositoryConstants;
import ma.wafa.cream.repository.search.ProspectionSearchRepository;
import ma.wafa.cream.service.AffectationService;
import ma.wafa.cream.service.CompagneService;
import ma.wafa.cream.service.PersonneService;
import ma.wafa.cream.service.ProspectionService;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.dto.CompagneDTO;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import ma.wafa.cream.web.rest.dto.ProspectImportDTO;
import ma.wafa.cream.web.rest.dto.ProspectionDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;
import ma.wafa.cream.web.rest.mapper.ProspectionMapper;
import ma.wafa.cream.web.rest.mapper.TacheMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Prospection.
 */
@Service
@Transactional
public class ProspectionServiceImpl implements ProspectionService{

    private final Logger log = LoggerFactory.getLogger(ProspectionServiceImpl.class);
    
    @Inject
    private ProspectionRepository prospectionRepository;
    
    @Inject
    private ProspectionMapper prospectionMapper;
    @Inject
    private TacheMapper tacheMapper;
    @Inject
    private ActionMapper actionMapper;
    
    @Inject
    private ProspectionSearchRepository prospectionSearchRepository;
    @Inject
    private RefStatutProspectionRepository refStatutProspectionRepository;

    @Inject
    private AffectationService affectationService;
    
    @Inject
    private PersonneService personneService;
    
    @Inject
    private CompagneService compagneService;
    
    /**
     * Save a prospection.
     * @return the persisted entity
     */
    /**
     * Save a prospection.
     * @return the persisted entity
     */
    public ProspectionDTO save(ProspectionDTO prospectionDTO) {
        log.debug("Request to save Prospection : {}", prospectionDTO);

        Prospection prospection = prospectionMapper.prospectionDTOToProspection(prospectionDTO);
        prospection = prospectionRepository.save(prospection);
        ProspectionDTO result = prospectionMapper.prospectionToProspectionDTO(prospection);
        prospectionSearchRepository.save(prospection);
        
        RefStatutProspection statutProspection = prospection.getStatutProspection();
        if (statutProspection != null && RepositoryConstants.REF_STATUT_PROSPECTION_EN_ATTENTE_CODE.equals(statutProspection.getCode())) {
            //if status en attente 
            affectationService.dispatch(prospection);
        }
        return result;
    }

    /**
     *  get all the prospections.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Prospection> findAll(Pageable pageable) {
        log.debug("Request to get all Prospections");
        Page<Prospection> result = prospectionRepository.findAll(pageable); 
        return result;
    }
    
    
    /**
     *  get all the prospections for connected user.
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true) 
    public Page<Prospection> findByUser(String user , Pageable pageable) {
        log.debug("Request to get all Prospections");
        Page<Prospection> result = prospectionRepository.findByAccessUser(user, pageable);
        return result;
    }
    
    
    @Override
    @Transactional(readOnly = true) 
    public Page<Prospection> findByStatutAQualifie(String user, Pageable pageable) {
        log.debug("Request to get all Prospections");
        RefStatutProspection statutProspection = refStatutProspectionRepository.findByCode(RepositoryConstants.REF_STATUT_PROSPECTION_A_QUALIFIE_CODE);
        Page<Prospection> result = prospectionRepository.findByUserAndStatutProspection(user, statutProspection , pageable); 
        return result;
    }
    
    
    @Override
    @Transactional(readOnly = true) 
    public Page<Prospection> findByStatutAQualifieEtNonAffecter(Pageable pageable) {
        log.debug("Request to get all Prospections");
        RefStatutProspection statutProspection = refStatutProspectionRepository.findByCode(RepositoryConstants.REF_STATUT_PROSPECTION_A_QUALIFIE_CODE);
		Page<Prospection> result = prospectionRepository.findByStatutProspectionAndUserIsNull(statutProspection , pageable); 
        return result;
    }
    

    /**
     *  get one prospection by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public ProspectionDTO findOne(Long id) {
        log.debug("Request to get Prospection : {}", id);
        Prospection prospection = prospectionRepository.findOne(id);
        
        ProspectionDTO prospectionDTO = prospectionMapper.prospectionToProspectionDTO(prospection);
        
        prospectionDTO.setTaches(tacheMapper.tachesToTacheDTOs(prospection.getTaches()));
        
        List<ActionDTO> actionsDto = getActions(prospection);
        
        prospectionDTO.setActions(actionsDto);
        return prospectionDTO;
    }

	private List <ActionDTO> getActions(Prospection prospection) {
		List <ActionDTO> actionsDTO = new ArrayList<ActionDTO>();
        for (Tache tache : prospection.getTaches()) {
        	 Set<ActionDTO> actionsSetDTO = actionMapper.mapActionsToActionDTOs(tache.getActions());
        	
        	 if (actionsSetDTO!=null && !actionsSetDTO.isEmpty()) {
				actionsDTO.addAll(new ArrayList<ActionDTO>(actionsSetDTO));
			}
		}
	return actionsDTO ; 
	}

	
    /**
     *  import prospect.
     */
	@Override
    public void importProspect(List<ProspectImportDTO> listProspectDto , Long compagneId ) {
        log.debug("Saving new Prospect from CSV ");
        compagneId = 2L ; 
        
        CompagneDTO compagneDto = compagneService.findOne(compagneId);
        for (ProspectImportDTO prospectImportDTO : listProspectDto) {
        	
        	ProspectionDTO prospectionDTO = new ProspectionDTO();
        	prospectionDTO.setCompagneId(compagneDto.getId());
        	
        	
        	PersonneDTO personneDTO = new PersonneDTO (); 
        	personneDTO.setNom(prospectImportDTO.getNom());
        	personneDTO.setPrenom(prospectImportDTO.getPrenom());
        	personneDTO.setTelephone(prospectImportDTO.getTel());
        	personneDTO.setNumeroCIN(prospectImportDTO.getCin());
        	personneDTO.setCodeAgence(prospectImportDTO.getCode_agence());

        	PersonneDTO personneDTOSaved = personneService.save(personneDTO);
        	
        	prospectionDTO.setPersonneId(personneDTOSaved.getId());
        	prospectionDTO.setDescription(" Import CSV");
        	prospectionDTO.setSujet(" Import de Fichier d'immatriculation");
        	prospectionDTO.setDateDebut(LocalDate.now());
        	prospectionDTO.setImmatriculation(prospectImportDTO.getImmatriculation());
        	prospectionDTO.setEnergie(prospectImportDTO.getPuissance());
        	prospectionDTO.setAnneeVignette(Integer.getInteger(prospectImportDTO.getAnnee_vignette()));
            prospectionDTO.setStatutProspectionId(refStatutProspectionRepository.findByCode(
                    RepositoryConstants.REF_STATUT_PROSPECTION_A_QUALIFIE_CODE).getId());
        	this.save(prospectionDTO);
        	
		}
        
        
        
    }

    
    /**
     *  delete the  prospection by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Prospection : {}", id);
        prospectionRepository.delete(id);
        prospectionSearchRepository.delete(id);
    }

    /**
     * search for the prospection corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<ProspectionDTO> search(String query) {
        // TODO : Ajouter cloisonnement
        log.debug("REST request to search Prospections for query {}", query);
        return StreamSupport
            .stream(prospectionSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(prospectionMapper::prospectionToProspectionDTO)
            .collect(Collectors.toList());
    }
}
