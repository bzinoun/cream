package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.RefStatutCompagne;
import ma.wafa.cream.repository.RefStatutCompagneRepository;
import ma.wafa.cream.repository.search.RefStatutCompagneSearchRepository;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.dto.RefStatutCompagneDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutCompagneMapper;
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
 * REST controller for managing RefStatutCompagne.
 */
@RestController
@RequestMapping("/api")
public class RefStatutCompagneResource {

    private final Logger log = LoggerFactory.getLogger(RefStatutCompagneResource.class);
        
    @Inject
    private RefStatutCompagneRepository refStatutCompagneRepository;
    
    @Inject
    private RefStatutCompagneMapper refStatutCompagneMapper;
    
    @Inject
    private RefStatutCompagneSearchRepository refStatutCompagneSearchRepository;
    
    /**
     * POST  /refStatutCompagnes -> Create a new refStatutCompagne.
     */
    @RequestMapping(value = "/refStatutCompagnes",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutCompagneDTO> createRefStatutCompagne(@Valid @RequestBody RefStatutCompagneDTO refStatutCompagneDTO) throws URISyntaxException {
        log.debug("REST request to save RefStatutCompagne : {}", refStatutCompagneDTO);
        if (refStatutCompagneDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("refStatutCompagne", "idexists", "A new refStatutCompagne cannot already have an ID")).body(null);
        }
        RefStatutCompagne refStatutCompagne = refStatutCompagneMapper.refStatutCompagneDTOToRefStatutCompagne(refStatutCompagneDTO);
        refStatutCompagne = refStatutCompagneRepository.save(refStatutCompagne);
        RefStatutCompagneDTO result = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);
        refStatutCompagneSearchRepository.save(refStatutCompagne);
        return ResponseEntity.created(new URI("/api/refStatutCompagnes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("refStatutCompagne", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /refStatutCompagnes -> Updates an existing refStatutCompagne.
     */
    @RequestMapping(value = "/refStatutCompagnes",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutCompagneDTO> updateRefStatutCompagne(@Valid @RequestBody RefStatutCompagneDTO refStatutCompagneDTO) throws URISyntaxException {
        log.debug("REST request to update RefStatutCompagne : {}", refStatutCompagneDTO);
        if (refStatutCompagneDTO.getId() == null) {
            return createRefStatutCompagne(refStatutCompagneDTO);
        }
        RefStatutCompagne refStatutCompagne = refStatutCompagneMapper.refStatutCompagneDTOToRefStatutCompagne(refStatutCompagneDTO);
        refStatutCompagne = refStatutCompagneRepository.save(refStatutCompagne);
        RefStatutCompagneDTO result = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);
        refStatutCompagneSearchRepository.save(refStatutCompagne);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("refStatutCompagne", refStatutCompagneDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /refStatutCompagnes -> get all the refStatutCompagnes.
     */
    @RequestMapping(value = "/refStatutCompagnes",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<RefStatutCompagneDTO> getAllRefStatutCompagnes() {
        log.debug("REST request to get all RefStatutCompagnes");
        return refStatutCompagneRepository.findAll().stream()
            .map(refStatutCompagneMapper::refStatutCompagneToRefStatutCompagneDTO)
            .collect(Collectors.toCollection(LinkedList::new));
            }

    /**
     * GET  /refStatutCompagnes/:id -> get the "id" refStatutCompagne.
     */
    @RequestMapping(value = "/refStatutCompagnes/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutCompagneDTO> getRefStatutCompagne(@PathVariable Long id) {
        log.debug("REST request to get RefStatutCompagne : {}", id);
        RefStatutCompagne refStatutCompagne = refStatutCompagneRepository.findOne(id);
        RefStatutCompagneDTO refStatutCompagneDTO = refStatutCompagneMapper.refStatutCompagneToRefStatutCompagneDTO(refStatutCompagne);
        return Optional.ofNullable(refStatutCompagneDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /refStatutCompagnes/:id -> delete the "id" refStatutCompagne.
     */
    @RequestMapping(value = "/refStatutCompagnes/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteRefStatutCompagne(@PathVariable Long id) {
        log.debug("REST request to delete RefStatutCompagne : {}", id);
        refStatutCompagneRepository.delete(id);
        refStatutCompagneSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("refStatutCompagne", id.toString())).build();
    }

    /**
     * SEARCH  /_search/refStatutCompagnes/:query -> search for the refStatutCompagne corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/refStatutCompagnes/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<RefStatutCompagneDTO> searchRefStatutCompagnes(@PathVariable String query) {
        log.debug("REST request to search RefStatutCompagnes for query {}", query);
        return StreamSupport
            .stream(refStatutCompagneSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refStatutCompagneMapper::refStatutCompagneToRefStatutCompagneDTO)
            .collect(Collectors.toList());
    }
}
