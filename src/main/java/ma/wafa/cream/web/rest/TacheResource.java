package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.service.TacheService;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;
import ma.wafa.cream.web.rest.dto.TacheDTO;
import ma.wafa.cream.web.rest.mapper.TacheMapper;
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
 * REST controller for managing Tache.
 */
@RestController
@RequestMapping("/api")
public class TacheResource {

    private final Logger log = LoggerFactory.getLogger(TacheResource.class);
        
    @Inject
    private TacheService tacheService;
    
    @Inject
    private TacheMapper tacheMapper;
    
    /**
     * POST  /taches -> Create a new tache.
     */
    @RequestMapping(value = "/taches",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<TacheDTO> createTache(@Valid @RequestBody TacheDTO tacheDTO) throws URISyntaxException {
        log.debug("REST request to save Tache : {}", tacheDTO);
        if (tacheDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("tache", "idexists", "A new tache cannot already have an ID")).body(null);
        }
        TacheDTO result = tacheService.save(tacheDTO);
        return ResponseEntity.created(new URI("/api/taches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("tache", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /taches -> Updates an existing tache.
     */
    @RequestMapping(value = "/taches",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<TacheDTO> updateTache(@Valid @RequestBody TacheDTO tacheDTO) throws URISyntaxException {
        log.debug("REST request to update Tache : {}", tacheDTO);
        if (tacheDTO.getId() == null) {
            return createTache(tacheDTO);
        }
        TacheDTO result = tacheService.save(tacheDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("tache", tacheDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /taches -> get all the taches.
     */
    @RequestMapping(value = "/taches",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<TacheDTO>> getAllTaches(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Taches");
        Page<Tache> page = tacheService.findByUserConnected(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/taches");
        return new ResponseEntity<>(page.getContent().stream()
            .map(tacheMapper::tacheToTacheDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }
    /**
     * GET  /taches -> get all the taches a planifier.
     */
    @RequestMapping(value = "/taches/a_planifier",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<TacheDTO> getAllTachesAplanifier()
    		throws URISyntaxException {
    	log.debug("REST request to get a page of Taches a_planifier");
    	List<TacheDTO> tacheDTO = tacheService.findAPlanifier(); 
    	
    	return tacheDTO;
    }

    /**
     * GET  /taches/:id -> get the "id" tache.
     */
    @RequestMapping(value = "/taches/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<TacheDTO> getTache(@PathVariable Long id) {
        log.debug("REST request to get Tache : {}", id);
        TacheDTO tacheDTO = tacheService.findOne(id);
        tacheDTO.setActions(tacheService.findActions(id));
        return Optional.ofNullable(tacheDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK)) 
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
    /**
     * GET  /taches/last/:id -> get the last "nbr" tache.
     * @throws URISyntaxException 
     */
    @RequestMapping(value = "/taches/last/{nbr}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<TacheDTO>> getLastNbrTache(@PathVariable int nbr) throws URISyntaxException {
        log.debug("REST request to get last Tache : {}", nbr);
        Page<Tache> page = tacheService.findLastNbrTache(nbr);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/taches");

        return new ResponseEntity<>(page.getContent().stream()
                .map(tacheMapper::tacheToTacheDTO)
                .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
        }

    /**
     * DELETE  /taches/:id -> delete the "id" tache.
     */
    @RequestMapping(value = "/taches/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        log.debug("REST request to delete Tache : {}", id);
        tacheService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("tache", id.toString())).build();
    }

    /**
     * SEARCH  /_search/taches/:query -> search for the tache corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/taches/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<TacheDTO> searchTaches(@PathVariable String query) {
        log.debug("Request to search Taches for query {}", query);
        return tacheService.search(query);
    }
}
