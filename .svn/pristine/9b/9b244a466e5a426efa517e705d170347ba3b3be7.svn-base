package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.service.PersonneService;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import ma.wafa.cream.web.rest.mapper.PersonneMapper;
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
 * REST controller for managing Personne.
 */
@RestController
@RequestMapping("/api")
public class PersonneResource {

    private final Logger log = LoggerFactory.getLogger(PersonneResource.class);
        
    @Inject
    private PersonneService personneService;
    
    @Inject
    private PersonneMapper personneMapper;
    
    /**
     * POST  /personnes -> Create a new personne.
     */
    @RequestMapping(value = "/personnes",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PersonneDTO> createPersonne(@Valid @RequestBody PersonneDTO personneDTO) throws URISyntaxException {
        log.debug("REST request to save Personne : {}", personneDTO);
        if (personneDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("personne", "idexists", "A new personne cannot already have an ID")).body(null);
        }
        PersonneDTO result = personneService.save(personneDTO);
        return ResponseEntity.created(new URI("/api/personnes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("personne", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /personnes -> Updates an existing personne.
     */
    @RequestMapping(value = "/personnes",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PersonneDTO> updatePersonne(@Valid @RequestBody PersonneDTO personneDTO) throws URISyntaxException {
        log.debug("REST request to update Personne : {}", personneDTO);
        if (personneDTO.getId() == null) {
            return createPersonne(personneDTO);
        }
        PersonneDTO result = personneService.save(personneDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("personne", personneDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /personnes -> get all the personnes.
     */
    @RequestMapping(value = "/personnes",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonneDTO>> getAllPersonnes(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Personnes");
        Page<Personne> page = personneService.findAll(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/personnes");
        return new ResponseEntity<>(page.getContent().stream()
            .map(personneMapper::personneToPersonneDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /personnes/:id -> get the "id" personne.
     */
    @RequestMapping(value = "/personnes/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PersonneDTO> getPersonne(@PathVariable Long id) {
        log.debug("REST request to get Personne : {}", id);
        PersonneDTO personneDTO = personneService.findOne(id);
        return Optional.ofNullable(personneDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /personnes/:id -> delete the "id" personne.
     */
    @RequestMapping(value = "/personnes/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        log.debug("REST request to delete Personne : {}", id);
        personneService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("personne", id.toString())).build();
    }

    /**
     * SEARCH  /_search/personnes/:query -> search for the personne corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/personnes/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<PersonneDTO> searchPersonnes(@PathVariable String query) {
        log.debug("Request to search Personnes for query {}", query);
        return personneService.search(query);
    }
}
