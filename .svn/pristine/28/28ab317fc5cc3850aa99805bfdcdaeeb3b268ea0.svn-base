package ma.wafa.cream.service.impl;

import ma.wafa.cream.service.PerferenceService;
import ma.wafa.cream.domain.Perference;
import ma.wafa.cream.repository.PerferenceRepository;
import ma.wafa.cream.repository.search.PerferenceSearchRepository;
import ma.wafa.cream.web.rest.dto.PerferenceDTO;
import ma.wafa.cream.web.rest.mapper.PerferenceMapper;
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
 * Service Implementation for managing Perference.
 */
@Service
@Transactional
public class PerferenceServiceImpl implements PerferenceService{

    private final Logger log = LoggerFactory.getLogger(PerferenceServiceImpl.class);
    
    @Inject
    private PerferenceRepository perferenceRepository;
    
    @Inject
    private PerferenceMapper perferenceMapper;
    
    @Inject
    private PerferenceSearchRepository perferenceSearchRepository;
    
    /**
     * Save a perference.
     * @return the persisted entity
     */
    public PerferenceDTO save(PerferenceDTO perferenceDTO) {
        log.debug("Request to save Perference : {}", perferenceDTO);
        Perference perference = perferenceMapper.perferenceDTOToPerference(perferenceDTO);
        perference = perferenceRepository.save(perference);
        PerferenceDTO result = perferenceMapper.perferenceToPerferenceDTO(perference);
        perferenceSearchRepository.save(perference);
        return result;
    }

    /**
     *  get all the perferences.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Perference> findAll(Pageable pageable) {
        log.debug("Request to get all Perferences");
        Page<Perference> result = perferenceRepository.findAll(pageable); 
        return result;
    }

    /**
     *  get one perference by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public PerferenceDTO findOne(Long id) {
        log.debug("Request to get Perference : {}", id);
        Perference perference = perferenceRepository.findOne(id);
        PerferenceDTO perferenceDTO = perferenceMapper.perferenceToPerferenceDTO(perference);
        return perferenceDTO;
    }

    /**
     *  delete the  perference by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Perference : {}", id);
        perferenceRepository.delete(id);
        perferenceSearchRepository.delete(id);
    }

    /**
     * search for the perference corresponding
     * to the query.
     */
    @Transactional(readOnly = true) 
    public List<PerferenceDTO> search(String query) {
        
        log.debug("REST request to search Perferences for query {}", query);
        return StreamSupport
            .stream(perferenceSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(perferenceMapper::perferenceToPerferenceDTO)
            .collect(Collectors.toList());
    }
}
