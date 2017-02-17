package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.Compagne;
import ma.wafa.cream.service.CompagneService;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;
import ma.wafa.cream.web.rest.dto.CompagneDTO;
import ma.wafa.cream.web.rest.mapper.CompagneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * REST controller for managing Compagne.
 */
@RestController
@RequestMapping("/api")
public class CompagneResource {

    private final Logger log = LoggerFactory.getLogger(CompagneResource.class);
        
    @Inject
    private CompagneService compagneService;
    
    @Inject
    private CompagneMapper compagneMapper;
    
    /**
     * POST  /compagnes -> Create a new compagne.
     */
    @RequestMapping(value = "/compagnes",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<CompagneDTO> createCompagne(@Valid @RequestBody CompagneDTO compagneDTO) throws URISyntaxException {
        log.debug("REST request to save Compagne : {}", compagneDTO);
        if (compagneDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("compagne", "idexists", "A new compagne cannot already have an ID")).body(null);
        }
        CompagneDTO result = compagneService.save(compagneDTO);
        return ResponseEntity.created(new URI("/api/compagnes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("compagne", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /compagnes -> Updates an existing compagne.
     */
    @RequestMapping(value = "/compagnes",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<CompagneDTO> updateCompagne(@Valid @RequestBody CompagneDTO compagneDTO) throws URISyntaxException {
        log.debug("REST request to update Compagne : {}", compagneDTO);
        if (compagneDTO.getId() == null) {
            return createCompagne(compagneDTO);
        }
        CompagneDTO result = compagneService.save(compagneDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("compagne", compagneDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /compagnes -> get all the compagnes.
     */
    @RequestMapping(value = "/compagnes",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<CompagneDTO>> getAllCompagnes(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Compagnes");
        Page<Compagne> page = compagneService.findAll(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/compagnes");
        return new ResponseEntity<>(page.getContent().stream()
            .map(compagneMapper::compagneToCompagneDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /compagnes/:id -> get the "id" compagne.
     */
    @RequestMapping(value = "/compagnes/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<CompagneDTO> getCompagne(@PathVariable Long id) {
        log.debug("REST request to get Compagne : {}", id);
        CompagneDTO compagneDTO = compagneService.findOne(id);
        return Optional.ofNullable(compagneDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /compagnes/:id -> delete the "id" compagne.
     */
    @RequestMapping(value = "/compagnes/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteCompagne(@PathVariable Long id) {
        log.debug("REST request to delete Compagne : {}", id);
        compagneService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("compagne", id.toString())).build();
    }

    /**
     * SEARCH  /_search/compagnes/:query -> search for the compagne corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/compagnes/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<CompagneDTO> searchCompagnes(@PathVariable String query) {
        log.debug("Request to search Compagnes for query {}", query);
        return compagneService.search(query);
    }
}
