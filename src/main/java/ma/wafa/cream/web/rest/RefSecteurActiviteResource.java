package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.RefSecteurActivite;
import ma.wafa.cream.repository.RefSecteurActiviteRepository;
import ma.wafa.cream.repository.search.RefSecteurActiviteSearchRepository;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.dto.RefSecteurActiviteDTO;
import ma.wafa.cream.web.rest.mapper.RefSecteurActiviteMapper;
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
 * REST controller for managing RefSecteurActivite.
 */
@RestController
@RequestMapping("/api")
public class RefSecteurActiviteResource {

    private final Logger log = LoggerFactory.getLogger(RefSecteurActiviteResource.class);
        
    @Inject
    private RefSecteurActiviteRepository refSecteurActiviteRepository;
    
    @Inject
    private RefSecteurActiviteMapper refSecteurActiviteMapper;
    
    @Inject
    private RefSecteurActiviteSearchRepository refSecteurActiviteSearchRepository;
    
    /**
     * POST  /refSecteurActivites -> Create a new refSecteurActivite.
     */
    @RequestMapping(value = "/refSecteurActivites",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSecteurActiviteDTO> createRefSecteurActivite(@Valid @RequestBody RefSecteurActiviteDTO refSecteurActiviteDTO) throws URISyntaxException {
        log.debug("REST request to save RefSecteurActivite : {}", refSecteurActiviteDTO);
        if (refSecteurActiviteDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("refSecteurActivite", "idexists", "A new refSecteurActivite cannot already have an ID")).body(null);
        }
        RefSecteurActivite refSecteurActivite = refSecteurActiviteMapper.refSecteurActiviteDTOToRefSecteurActivite(refSecteurActiviteDTO);
        refSecteurActivite = refSecteurActiviteRepository.save(refSecteurActivite);
        RefSecteurActiviteDTO result = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);
        refSecteurActiviteSearchRepository.save(refSecteurActivite);
        return ResponseEntity.created(new URI("/api/refSecteurActivites/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("refSecteurActivite", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /refSecteurActivites -> Updates an existing refSecteurActivite.
     */
    @RequestMapping(value = "/refSecteurActivites",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSecteurActiviteDTO> updateRefSecteurActivite(@Valid @RequestBody RefSecteurActiviteDTO refSecteurActiviteDTO) throws URISyntaxException {
        log.debug("REST request to update RefSecteurActivite : {}", refSecteurActiviteDTO);
        if (refSecteurActiviteDTO.getId() == null) {
            return createRefSecteurActivite(refSecteurActiviteDTO);
        }
        RefSecteurActivite refSecteurActivite = refSecteurActiviteMapper.refSecteurActiviteDTOToRefSecteurActivite(refSecteurActiviteDTO);
        refSecteurActivite = refSecteurActiviteRepository.save(refSecteurActivite);
        RefSecteurActiviteDTO result = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);
        refSecteurActiviteSearchRepository.save(refSecteurActivite);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("refSecteurActivite", refSecteurActiviteDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /refSecteurActivites -> get all the refSecteurActivites.
     */
    @RequestMapping(value = "/refSecteurActivites",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<RefSecteurActiviteDTO> getAllRefSecteurActivites() {
        log.debug("REST request to get all RefSecteurActivites");
        return refSecteurActiviteRepository.findAll().stream()
            .map(refSecteurActiviteMapper::refSecteurActiviteToRefSecteurActiviteDTO)
            .collect(Collectors.toCollection(LinkedList::new));
            }

    /**
     * GET  /refSecteurActivites/:id -> get the "id" refSecteurActivite.
     */
    @RequestMapping(value = "/refSecteurActivites/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RefSecteurActiviteDTO> getRefSecteurActivite(@PathVariable Long id) {
        log.debug("REST request to get RefSecteurActivite : {}", id);
        RefSecteurActivite refSecteurActivite = refSecteurActiviteRepository.findOne(id);
        RefSecteurActiviteDTO refSecteurActiviteDTO = refSecteurActiviteMapper.refSecteurActiviteToRefSecteurActiviteDTO(refSecteurActivite);
        return Optional.ofNullable(refSecteurActiviteDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /refSecteurActivites/:id -> delete the "id" refSecteurActivite.
     */
    @RequestMapping(value = "/refSecteurActivites/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteRefSecteurActivite(@PathVariable Long id) {
        log.debug("REST request to delete RefSecteurActivite : {}", id);
        refSecteurActiviteRepository.delete(id);
        refSecteurActiviteSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("refSecteurActivite", id.toString())).build();
    }

    /**
     * SEARCH  /_search/refSecteurActivites/:query -> search for the refSecteurActivite corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/refSecteurActivites/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<RefSecteurActiviteDTO> searchRefSecteurActivites(@PathVariable String query) {
        log.debug("REST request to search RefSecteurActivites for query {}", query);
        return StreamSupport
            .stream(refSecteurActiviteSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(refSecteurActiviteMapper::refSecteurActiviteToRefSecteurActiviteDTO)
            .collect(Collectors.toList());
    }
}
