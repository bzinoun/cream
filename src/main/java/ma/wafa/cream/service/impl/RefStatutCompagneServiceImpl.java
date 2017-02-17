package ma.wafa.cream.service.impl;

import ma.wafa.cream.service.RefStatutCompagneService;
import ma.wafa.cream.domain.RefStatutCompagne;
import ma.wafa.cream.repository.RefStatutCompagneRepository;
import ma.wafa.cream.repository.search.RefStatutCompagneSearchRepository;
import ma.wafa.cream.web.rest.dto.RefStatutCompagneDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutCompagneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Service Implementation for managing RefStatutCompagne.
 */
@Service
@Transactional
public class RefStatutCompagneServiceImpl implements RefStatutCompagneService{

    private final Logger log = LoggerFactory.getLogger(RefStatutCompagneServiceImpl.class);
    
    @Inject
    private RefStatutCompagneRepository refStatutCompagneRepository;
    
    @Inject
    private RefStatutCompagneMapper refStatutCompagneMapper;
    
    @Inject
    private RefStatutCompagneSearchRepository refStatutCompagneSearchRepository;
    
    /**
     * Save a refStatutCompagne.
     * @return the persisted entity
     */
    public RefStatutCompagneDTO save(RefStatutCompagneDTO refStatutCompagneDTO) {
        log.debug("Request to save RefStatutCompagne : {}", refStatutCompagneDTO);
        RefStatutCompagne refStatutCompagne = refStatutCompagneMapper.refStatutCompagneDTOToRefStatutCompagne(refStatutCompagneDTO);
        refStatutCompagne = refStatutCompagneRepository.save(refStatutCompagne);
        RefStatutCompagneDTO result = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);
        refStatutCompagneSearchRepository.save(refStatutCompagne);
        return result;
    }

    /**
     *  get all the refStatutCompagnes.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<RefStatutCompagneDTO> findAll() {
        log.debug("Request to get all RefStatutCompagnes");
        List<RefStatutCompagneDTO> result = refStatutCompagneRepository.findAll().stream()
            .map(refStatutCompagneMapper::refStatutCompagneToRefStatutCompagneDTO)
            .collect(Collectors.toCollection(LinkedList::new));
        return result;
    }

    /**
     *  get one refStatutCompagne by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public RefStatutCompagneDTO findOne(Long id) {
        log.debug("Request to get RefStatutCompagne : {}", id);
        RefStatutCompagne refStatutCompagne = refStatutCompagneRepository.findOne(id);
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);
        return refStatutCompagneDTO;
    }

    /**
     *  delete the  refStatutCompagne by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete RefStatutCompagne : {}", id);
        refStatutCompagneRepository.delete(id);
        refStatutCompagneSearchRepository.delete(id);
    }

    /**
     * search for the refStatutCompagne corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<RefStatutCompagneDTO> search(String query) {
        
        log.debug("REST request to search RefStatutCompagnes for query {}", query);
        return StreamSupport
            .stream(refStatutCompagneSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refStatutCompagneMapper::refStatutCompagneToRefStatutCompagneDTO)
            .collect(Collectors.toList());
    }
}
