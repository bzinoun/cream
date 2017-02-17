package ma.wafa.cream.service.impl;

import ma.wafa.cream.service.CompagneService;
import ma.wafa.cream.domain.Compagne;
import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.repository.CompagneRepository;
import ma.wafa.cream.repository.search.CompagneSearchRepository;
import ma.wafa.cream.web.rest.dto.CompagneDTO;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import ma.wafa.cream.web.rest.mapper.CompagneMapper;
import ma.wafa.cream.web.rest.mapper.PersonneMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * Service Implementation for managing Compagne.
 */
@Service
@Transactional
public class CompagneServiceImpl implements CompagneService{

    private final Logger log = LoggerFactory.getLogger(CompagneServiceImpl.class);
    
    @Inject
    private CompagneRepository compagneRepository;
    
    @Inject
    private CompagneMapper compagneMapper;
    @Inject
    private PersonneMapper personneMapper;
    
    @Inject
    private CompagneSearchRepository compagneSearchRepository;
    
    /**
     * Save a compagne.
     * @return the persisted entity
     */
    public CompagneDTO save(CompagneDTO compagneDTO) {
        log.debug("Request to save Compagne : {}", compagneDTO);
        Compagne compagne = compagneMapper.compagneDTOToCompagne(compagneDTO);
        compagne = compagneRepository.save(compagne);
        CompagneDTO result = compagneMapper.compagneToCompagneDTO(compagne);
        compagneSearchRepository.save(compagne);
        return result;
    }

    /**
     *  get all the compagnes.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Compagne> findAll(Pageable pageable) {
        log.debug("Request to get all Compagnes");
        Page<Compagne> result = compagneRepository.findAll(pageable); 
        return result;
    }

    /**
     *  get one compagne by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public CompagneDTO findOne(Long id) {
        log.debug("Request to get Compagne : {}", id);
        List<PersonneDTO> personnesDto = new ArrayList<PersonneDTO>() ; 
        Compagne compagne = compagneRepository.findOne(id);
        Set<Prospection> prospections = compagne.getProspections();
        prospections.forEach(p ->  personnesDto.add(getPersonneFromProspection(p)));
        CompagneDTO compagneDTO = compagneMapper.compagneToCompagneDTO(compagne);
       compagneDTO.setPersonnes(personnesDto);
        System.out.println(personnesDto);
        return compagneDTO;
    }

	private PersonneDTO getPersonneFromProspection(Prospection p) {
		PersonneDTO personneDTO = personneMapper.personneToPersonneDTO(p.getPersonne());
		personneDTO.set_prospectionLibelle(p.getSujet());
		return personneDTO;
	}

    /**
     *  delete the  compagne by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Compagne : {}", id);
        compagneRepository.delete(id);
        compagneSearchRepository.delete(id);
    }

    /**
     * search for the compagne corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<CompagneDTO> search(String query) {
        
        log.debug("REST request to search Compagnes for query {}", query);
        return StreamSupport
            .stream(compagneSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(compagneMapper::compagneToCompagneDTO)
            .collect(Collectors.toList());
    }
}
