package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.RefStatutProspection;
import ma.wafa.cream.repository.RefStatutProspectionRepository;
import ma.wafa.cream.repository.search.RefStatutProspectionSearchRepository;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.dto.RefStatutProspectionDTO;
import ma.wafa.cream.web.rest.mapper.RefStatutProspectionMapper;
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
 * REST controller for managing RefStatutProspection.
 */
@RestController
@RequestMapping("/api")
public class RefStatutProspectionResource {

    private final Logger log = LoggerFactory.getLogger(RefStatutProspectionResource.class);
        
    @Inject
    private RefStatutProspectionRepository refStatutProspectionRepository;
    
    @Inject
    private RefStatutProspectionMapper refStatutProspectionMapper;
    
    @Inject
    private RefStatutProspectionSearchRepository refStatutProspectionSearchRepository;
    
    /**
     * POST  /refStatutProspections -> Create a new refStatutProspection.
     */
    @RequestMapping(value = "/refStatutProspections",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutProspectionDTO> createRefStatutProspection(@Valid @RequestBody RefStatutProspectionDTO refStatutProspectionDTO) throws URISyntaxException {
        log.debug("REST request to save RefStatutProspection : {}", refStatutProspectionDTO);
        if (refStatutProspectionDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("refStatutProspection", "idexists", "A new refStatutProspection cannot already have an ID")).body(null);
        }
        RefStatutProspection refStatutProspection = refStatutProspectionMapper.refStatutProspectionDTOToRefStatutProspection(refStatutProspectionDTO);
        refStatutProspection = refStatutProspectionRepository.save(refStatutProspection);
        RefStatutProspectionDTO result = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);
        refStatutProspectionSearchRepository.save(refStatutProspection);
        return ResponseEntity.created(new URI("/api/refStatutProspections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("refStatutProspection", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /refStatutProspections -> Updates an existing refStatutProspection.
     */
    @RequestMapping(value = "/refStatutProspections",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutProspectionDTO> updateRefStatutProspection(@Valid @RequestBody RefStatutProspectionDTO refStatutProspectionDTO) throws URISyntaxException {
        log.debug("REST request to update RefStatutProspection : {}", refStatutProspectionDTO);
        if (refStatutProspectionDTO.getId() == null) {
            return createRefStatutProspection(refStatutProspectionDTO);
        }
        RefStatutProspection refStatutProspection = refStatutProspectionMapper.refStatutProspectionDTOToRefStatutProspection(refStatutProspectionDTO);
        refStatutProspection = refStatutProspectionRepository.save(refStatutProspection);
        RefStatutProspectionDTO result = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);
        refStatutProspectionSearchRepository.save(refStatutProspection);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("refStatutProspection", refStatutProspectionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /refStatutProspections -> get all the refStatutProspections.
     */
    @RequestMapping(value = "/refStatutProspections",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<RefStatutProspectionDTO> getAllRefStatutProspections() {
        log.debug("REST request to get all RefStatutProspections");
        return refStatutProspectionRepository.findAll().stream()
            .map(refStatutProspectionMapper::refStatutProspectionToRefStatutProspectionDTO)
            .collect(Collectors.toCollection(LinkedList::new));
            }

    /**
     * GET  /refStatutProspections/:id -> get the "id" refStatutProspection.
     */
    @RequestMapping(value = "/refStatutProspections/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefStatutProspectionDTO> getRefStatutProspection(@PathVariable Long id) {
        log.debug("REST request to get RefStatutProspection : {}", id);
        RefStatutProspection refStatutProspection = refStatutProspectionRepository.findOne(id);
        RefStatutProspectionDTO refStatutProspectionDTO = refStatutProspectionMapper.refStatutProspectionToRefStatutProspectionDTO(refStatutProspection);
        return Optional.ofNullable(refStatutProspectionDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /refStatutProspections/:id -> delete the "id" refStatutProspection.
     */
    @RequestMapping(value = "/refStatutProspections/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteRefStatutProspection(@PathVariable Long id) {
        log.debug("REST request to delete RefStatutProspection : {}", id);
        refStatutProspectionRepository.delete(id);
        refStatutProspectionSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("refStatutProspection", id.toString())).build();
    }

    /**
     * SEARCH  /_search/refStatutProspections/:query -> search for the refStatutProspection corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/refStatutProspections/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<RefStatutProspectionDTO> searchRefStatutProspections(@PathVariable String query) {
        log.debug("REST request to search RefStatutProspections for query {}", query);
        return StreamSupport
            .stream(refStatutProspectionSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refStatutProspectionMapper::refStatutProspectionToRefStatutProspectionDTO)
            .collect(Collectors.toList());
    }
}
