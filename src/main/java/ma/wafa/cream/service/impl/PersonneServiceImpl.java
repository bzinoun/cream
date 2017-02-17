package ma.wafa.cream.service.impl;

import ma.wafa.cream.service.PersonneService;
import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.repository.PersonneRepository;
import ma.wafa.cream.repository.search.PersonneSearchRepository;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import ma.wafa.cream.web.rest.mapper.PersonneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Personne.
 */
@Service
@Transactional
public class PersonneServiceImpl implements PersonneService{

    private final Logger log = LoggerFactory.getLogger(PersonneServiceImpl.class);
    
    @Inject
    private PersonneRepository personneRepository;
    
    @Inject
    private PersonneMapper personneMapper;
    
    @Inject
    private PersonneSearchRepository personneSearchRepository;
    
    /**
     * Save a personne.
     * @return the persisted entity
     */
    public PersonneDTO save(PersonneDTO personneDTO) {
        log.debug("Request to save Personne : {}", personneDTO);
        Personne personne = personneMapper.personneDTOToPersonne(personneDTO);
        personne = personneRepository.save(personne);
        PersonneDTO result = personneMapper.personneToPersonneDTO(personne);
        personneSearchRepository.save(personne);
        return result;
    }

    /**
     *  get all the personnes.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Personne> findAll(Pageable pageable) {
        log.debug("Request to get all Personnes");
        Page<Personne> result = personneRepository.findAll(pageable); 
        return result;
    }

    /**
     *  get one personne by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public PersonneDTO findOne(Long id) {
        log.debug("Request to get Personne : {}", id);
        Personne personne = personneRepository.findOne(id);
        PersonneDTO personneDTO = personneMapper.personneToPersonneDTO(personne);
        return personneDTO;
    }

    /**
     *  delete the  personne by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Personne : {}", id);
        personneRepository.delete(id);
        personneSearchRepository.delete(id);
    }

    /**
     * search for the personne corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<PersonneDTO> search(String query) {
        
        log.debug("REST request to search Personnes for query {}", query);
        return StreamSupport
            .stream(personneSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(personneMapper::personneToPersonneDTO)
            .collect(Collectors.toList());
    }
}
