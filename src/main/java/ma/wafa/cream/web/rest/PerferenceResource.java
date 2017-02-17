package ma.wafa.cream.web.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.Valid;

import ma.wafa.cream.domain.Perference;
import ma.wafa.cream.service.PerferenceService;
import ma.wafa.cream.service.ProspectionService;
import ma.wafa.cream.service.util.CsvFileReader;
import ma.wafa.cream.web.rest.dto.PerferenceDTO;
import ma.wafa.cream.web.rest.dto.ProspectImportDTO;
import ma.wafa.cream.web.rest.mapper.PerferenceMapper;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;

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
 * REST controller for managing Perference.
 */
@RestController
@RequestMapping("/api")
public class PerferenceResource {

    private final Logger log = LoggerFactory.getLogger(PerferenceResource.class);
        
    @Inject
    private PerferenceService perferenceService;

    @Inject 
    PerferenceMapper perferenceMapper ; 
    
    @Inject
    private ProspectionService prospectionService;
    
    /**
     * POST  /perferences -> Create a new perference.
     */
    @RequestMapping(value = "/perferences",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PerferenceDTO> createPerference(@Valid @RequestBody PerferenceDTO perferenceDTO) throws URISyntaxException {
        log.debug("REST request to save Perference : {}", perferenceDTO);
        if (perferenceDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("perference", "idexists", "A new perference cannot already have an ID")).body(null);
        }
        PerferenceDTO result = perferenceService.save(perferenceDTO);
        return ResponseEntity.created(new URI("/api/perferences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("perference", result.getId().toString()))
            .body(result);
    }
    /**
     * POST  /perferences -> import 
     * @throws IOException 
     */
    @RequestMapping(value = "/perferences/import",
    		method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> importProspect() throws URISyntaxException, IOException {
    	
    	log.debug("REST request to Import prospect ");
    	String path = "C:/_dev/importCRM.csv";
    	List<ProspectImportDTO> listProspectDto = CsvFileReader.run(path);
    	prospectionService.importProspect(listProspectDto, 2L);
    	
    	return  ResponseEntity.ok().headers(HeaderUtil.operationReussi()).build();
    }

    /**
     * PUT  /perferences -> Updates an existing perference.
     */
    @RequestMapping(value = "/perferences",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PerferenceDTO> updatePerference(@Valid @RequestBody PerferenceDTO perferenceDTO) throws URISyntaxException {
        log.debug("REST request to update Perference : {}", perferenceDTO);
        if (perferenceDTO.getId() == null) {
            return createPerference(perferenceDTO);
        }
        PerferenceDTO result = perferenceService.save(perferenceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("perference", perferenceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /perferences -> get all the perferences.
     */
    @RequestMapping(value = "/perferences",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<PerferenceDTO>> getAllPerferences(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Perferences");
        Page<Perference> page = perferenceService.findAll(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/perferences");
        return new ResponseEntity<>(page.getContent().stream()
            .map(perferenceMapper::perferenceToPerferenceDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /perferences/:id -> get the "id" perference.
     */
    @RequestMapping(value = "/perferences/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PerferenceDTO> getPerference(@PathVariable Long id) {
        log.debug("REST request to get Perference : {}", id);
        PerferenceDTO perferenceDTO = perferenceService.findOne(id);
        return Optional.ofNullable(perferenceDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /perferences/:id -> delete the "id" perference.
     */
    @RequestMapping(value = "/perferences/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deletePerference(@PathVariable Long id) {
        log.debug("REST request to delete Perference : {}", id);
        perferenceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("perference", id.toString())).build();
    }

    /**
     * SEARCH  /_search/perferences/:query -> search for the perference corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/perferences/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<PerferenceDTO> searchPerferences(@PathVariable String query) {
        log.debug("Request to search Perferences for query {}", query);
        return perferenceService.search(query);
    }
}
