package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.search.RefStatutTacheSearchRepository;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.dto.RefStatutTacheDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutTacheMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing RefStatutTache.
 */
@RestController
@RequestMapping("/api")
public class RefStatutTacheResource {

    private final Logger log = LoggerFactory.getLogger(RefStatutTacheResource.class);
        
    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;
    
    @Inject
    private RefStatutTacheMapper refStatutTacheMapper;
    
    @Inject
    private RefStatutTacheSearchRepository refStatutTacheSearchRepository;
    
    /**
     * POST  /refStatutTaches -> Create a new refStatutTache.
     */
    @RequestMapping(value = "/refStatutTaches",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutTacheDTO> createRefStatutTache(@Valid @RequestBody RefStatutTacheDTO refStatutTacheDTO) throws URISyntaxException {
        log.debug("REST request to save RefStatutTache : {}", refStatutTacheDTO);
        if (refStatutTacheDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("refStatutTache", "idexists", "A new refStatutTache cannot already have an ID")).body(null);
        }
        RefStatutTache refStatutTache = refStatutTacheMapper.refStatutTacheDTOToRefStatutTache(refStatutTacheDTO);
        refStatutTache = refStatutTacheRepository.save(refStatutTache);
        RefStatutTacheDTO result = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);
        refStatutTacheSearchRepository.save(refStatutTache);
        return ResponseEntity.created(new URI("/api/refStatutTaches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("refStatutTache", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /refStatutTaches -> Updates an existing refStatutTache.
     */
    @RequestMapping(value = "/refStatutTaches",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutTacheDTO> updateRefStatutTache(@Valid @RequestBody RefStatutTacheDTO refStatutTacheDTO) throws URISyntaxException {
        log.debug("REST request to update RefStatutTache : {}", refStatutTacheDTO);
        if (refStatutTacheDTO.getId() == null) {
            return createRefStatutTache(refStatutTacheDTO);
        }
        RefStatutTache refStatutTache = refStatutTacheMapper.refStatutTacheDTOToRefStatutTache(refStatutTacheDTO);
        refStatutTache = refStatutTacheRepository.save(refStatutTache);
        RefStatutTacheDTO result = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);
        refStatutTacheSearchRepository.save(refStatutTache);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("refStatutTache", refStatutTacheDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /refStatutTaches -> get all the refStatutTaches.
     */
    @RequestMapping(value = "/refStatutTaches",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<RefStatutTacheDTO> getAllRefStatutTaches() {
        log.debug("REST request to get all RefStatutTaches");
        return refStatutTacheRepository.findAll().stream()
            .map(refStatutTacheMapper::refStatutTacheToRefStatutTacheDTO)
            .collect(Collectors.toCollection(LinkedList::new));
            }

    /**
     * GET  /refStatutTaches/:id -> get the "id" refStatutTache.
     */
    @RequestMapping(value = "/refStatutTaches/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutTacheDTO> getRefStatutTache(@PathVariable Long id) {
        log.debug("REST request to get RefStatutTache : {}", id);
        RefStatutTache refStatutTache = refStatutTacheRepository.findOne(id);
        RefStatutTacheDTO refStatutTacheDTO = refStatutTacheMapper.refStatutTacheToRefStatutTacheDTO(refStatutTache);
        return Optional.ofNullable(refStatutTacheDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /refStatutTaches/:id -> delete the "id" refStatutTache.
     */
    @RequestMapping(value = "/refStatutTaches/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteRefStatutTache(@PathVariable Long id) {
        log.debug("REST request to delete RefStatutTache : {}", id);
        refStatutTacheRepository.delete(id);
        refStatutTacheSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("refStatutTache", id.toString())).build();
    }

    /**
     * SEARCH  /_search/refStatutTaches/:query -> search for the refStatutTache corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/refStatutTaches/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<RefStatutTacheDTO> searchRefStatutTaches(@PathVariable String query) {
        log.debug("REST request to search RefStatutTaches for query {}", query);
        return StreamSupport
            .stream(refStatutTacheSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refStatutTacheMapper::refStatutTacheToRefStatutTacheDTO)
            .collect(Collectors.toList());
    }
}
