package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.RefSituationFamiliale;
import ma.wafa.cream.repository.RefSituationFamilialeRepository;
import ma.wafa.cream.repository.search.RefSituationFamilialeSearchRepository;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.dto.RefSituationFamilialeDTO;
import ma.wafa.cream.web.rest.mapper.RefSituationFamilialeMapper;
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
 * REST controller for managing RefSituationFamiliale.
 */
@RestController
@RequestMapping("/api")
public class RefSituationFamilialeResource {

    private final Logger log = LoggerFactory.getLogger(RefSituationFamilialeResource.class);
        
    @Inject
    private RefSituationFamilialeRepository refSituationFamilialeRepository;
    
    @Inject
    private RefSituationFamilialeMapper refSituationFamilialeMapper;
    
    @Inject
    private RefSituationFamilialeSearchRepository refSituationFamilialeSearchRepository;
    
    /**
     * POST  /refSituationFamiliales -> Create a new refSituationFamiliale.
     */
    @RequestMapping(value = "/refSituationFamiliales",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSituationFamilialeDTO> createRefSituationFamiliale(@Valid @RequestBody RefSituationFamilialeDTO refSituationFamilialeDTO) throws URISyntaxException {
        log.debug("REST request to save RefSituationFamiliale : {}", refSituationFamilialeDTO);
        if (refSituationFamilialeDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("refSituationFamiliale", "idexists", "A new refSituationFamiliale cannot already have an ID")).body(null);
        }
        RefSituationFamiliale refSituationFamiliale = refSituationFamilialeMapper.refSituationFamilialeDTOToRefSituationFamiliale(refSituationFamilialeDTO);
        refSituationFamiliale = refSituationFamilialeRepository.save(refSituationFamiliale);
        RefSituationFamilialeDTO result = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);
        refSituationFamilialeSearchRepository.save(refSituationFamiliale);
        return ResponseEntity.created(new URI("/api/refSituationFamiliales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("refSituationFamiliale", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /refSituationFamiliales -> Updates an existing refSituationFamiliale.
     */
    @RequestMapping(value = "/refSituationFamiliales",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSituationFamilialeDTO> updateRefSituationFamiliale(@Valid @RequestBody RefSituationFamilialeDTO refSituationFamilialeDTO) throws URISyntaxException {
        log.debug("REST request to update RefSituationFamiliale : {}", refSituationFamilialeDTO);
        if (refSituationFamilialeDTO.getId() == null) {
            return createRefSituationFamiliale(refSituationFamilialeDTO);
        }
        RefSituationFamiliale refSituationFamiliale = refSituationFamilialeMapper.refSituationFamilialeDTOToRefSituationFamiliale(refSituationFamilialeDTO);
        refSituationFamiliale = refSituationFamilialeRepository.save(refSituationFamiliale);
        RefSituationFamilialeDTO result = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);
        refSituationFamilialeSearchRepository.save(refSituationFamiliale);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("refSituationFamiliale", refSituationFamilialeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /refSituationFamiliales -> get all the refSituationFamiliales.
     */
    @RequestMapping(value = "/refSituationFamiliales",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<RefSituationFamilialeDTO> getAllRefSituationFamiliales() {
        log.debug("REST request to get all RefSituationFamiliales");
        return refSituationFamilialeRepository.findAll().stream()
            .map(refSituationFamilialeMapper::refSituationFamilialeToRefSituationFamilialeDTO)
            .collect(Collectors.toCollection(LinkedList::new));
            }

    /**
     * GET  /refSituationFamiliales/:id -> get the "id" refSituationFamiliale.
     */
    @RequestMapping(value = "/refSituationFamiliales/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSituationFamilialeDTO> getRefSituationFamiliale(@PathVariable Long id) {
        log.debug("REST request to get RefSituationFamiliale : {}", id);
        RefSituationFamiliale refSituationFamiliale = refSituationFamilialeRepository.findOne(id);
        RefSituationFamilialeDTO refSituationFamilialeDTO = refSituationFamilialeMapper.refSituationFamilialeToRefSituationFamilialeDTO(refSituationFamiliale);
        return Optional.ofNullable(refSituationFamilialeDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /refSituationFamiliales/:id -> delete the "id" refSituationFamiliale.
     */
    @RequestMapping(value = "/refSituationFamiliales/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteRefSituationFamiliale(@PathVariable Long id) {
        log.debug("REST request to delete RefSituationFamiliale : {}", id);
        refSituationFamilialeRepository.delete(id);
        refSituationFamilialeSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("refSituationFamiliale", id.toString())).build();
    }

    /**
     * SEARCH  /_search/refSituationFamiliales/:query -> search for the refSituationFamiliale corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/refSituationFamiliales/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<RefSituationFamilialeDTO> searchRefSituationFamiliales(@PathVariable String query) {
        log.debug("REST request to search RefSituationFamiliales for query {}", query);
        return StreamSupport
            .stream(refSituationFamilialeSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refSituationFamilialeMapper::refSituationFamilialeToRefSituationFamilialeDTO)
            .collect(Collectors.toList());
    }
}
