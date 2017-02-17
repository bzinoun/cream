package ma.wafa.cream.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.Valid;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.security.SecurityUtils;
import ma.wafa.cream.service.ProspectionService;
import ma.wafa.cream.web.rest.dto.ProspectionDTO;
import ma.wafa.cream.web.rest.mapper.ProspectionMapper;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing Prospection.
 */
@RestController
@RequestMapping("/api")
public class ProspectionResource {

    private final Logger log = LoggerFactory.getLogger(ProspectionResource.class);
        
    @Inject
    private ProspectionService prospectionService;
    
    @Inject
    private ProspectionMapper prospectionMapper;
    
    /**
     * POST  /prospections -> Create a new prospection.
     */
    @RequestMapping(value = "/prospections",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ProspectionDTO> createProspection(@Valid @RequestBody ProspectionDTO prospectionDTO) throws URISyntaxException {
        log.debug("REST request to save Prospection : {}", prospectionDTO);
        if (prospectionDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("prospection", "idexists", "A new prospection cannot already have an ID")).body(null);
        }
        ProspectionDTO result = prospectionService.save(prospectionDTO);
        return ResponseEntity.created(new URI("/api/prospections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("prospection", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /prospections -> Updates an existing prospection.
     */
    @RequestMapping(value = "/prospections",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ProspectionDTO> updateProspection(@Valid @RequestBody ProspectionDTO prospectionDTO) throws URISyntaxException {
        log.debug("REST request to update Prospection : {}", prospectionDTO);
        if (prospectionDTO.getId() == null) {
            return createProspection(prospectionDTO);
        }
        
//        String user = SecurityUtils.getCurrentUserLogin();
//        if(StringUtils.isBlank(prospectionDTO.getUser()) && SecurityUtils.isCurrentUserInRole("ROLE_QUALIF")){
//            prospectionDTO.setUser(user);
//        }
        
        ProspectionDTO result = prospectionService.save(prospectionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("prospection", prospectionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /prospections -> get all the prospections.
     */
    @RequestMapping(value = "/prospections",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProspectionDTO>> getAllProspections(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Prospections");
        
        Page<Prospection> page;
        String user = SecurityUtils.getCurrentUserLogin();

        if(SecurityUtils.isCurrentUserInRole("ROLE_QUALIF")) {
            page = prospectionService.findByStatutAQualifie(user, pageable);
        } else {
            page = prospectionService.findByUser(user, pageable);
        }
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/prospections");
        return new ResponseEntity<>(page.getContent().stream()
            .map(prospectionMapper::prospectionToProspectionDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }
    /**
     * GET  /prospections -> get all the prospections.
     */
    @RequestMapping(value = "/prospections/a_qualifie",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProspectionDTO>> getAllProspectionsAQualifie(Pageable pageable)
    		throws URISyntaxException {
    	log.debug("REST request to get a page of Prospections to qualify");
    	Page<Prospection> page = prospectionService.findByStatutAQualifieEtNonAffecter(pageable); 
    	HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/prospections/a_qualifie");
    	return new ResponseEntity<>(page.getContent().stream()
    			.map(prospectionMapper::prospectionToProspectionDTO)
    			.collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /prospections/:id -> get the "id" prospection.
     */
    @RequestMapping(value = "/prospections/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ProspectionDTO> getProspection(@PathVariable Long id) {
        log.debug("REST request to get Prospection : {}", id);
        ProspectionDTO prospectionDTO = prospectionService.findOne(id);
        return Optional.ofNullable(prospectionDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /prospections/:id -> delete the "id" prospection.
     */
    @RequestMapping(value = "/prospections/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteProspection(@PathVariable Long id) {
        log.debug("REST request to delete Prospection : {}", id);
        prospectionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("prospection", id.toString())).build();
    }

    /**
     * SEARCH  /_search/prospections/:query -> search for the prospection corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/prospections/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<ProspectionDTO> searchProspections(@PathVariable String query) {
        log.debug("Request to search Prospections for query {}", query);
        return prospectionService.search(query);
    }
}
