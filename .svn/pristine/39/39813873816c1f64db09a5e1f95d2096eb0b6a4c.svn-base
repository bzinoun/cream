package ma.wafa.cream.web.rest;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.Action;
import ma.wafa.cream.service.ActionService;
import ma.wafa.cream.web.rest.util.HeaderUtil;
import ma.wafa.cream.web.rest.util.PaginationUtil;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.mapper.ActionMapper;
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
 * REST controller for managing Action.
 */
@RestController
@RequestMapping("/api")
public class ActionResource {

    private final Logger log = LoggerFactory.getLogger(ActionResource.class);
        
    @Inject
    private ActionService actionService;
    
    @Inject
    private ActionMapper actionMapper;
    
    /**
     * POST  /actions -> Create a new action.
     */
    @RequestMapping(value = "/actions",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ActionDTO> createAction(@Valid @RequestBody ActionDTO actionDTO) throws URISyntaxException {
        log.debug("REST request to save Action : {}", actionDTO);
        if (actionDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("action", "idexists", "A new action cannot already have an ID")).body(null);
        }
        ActionDTO result = actionService.save(actionDTO);
        return ResponseEntity.created(new URI("/api/actions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("action", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /actions -> Updates an existing action.
     */
    @RequestMapping(value = "/actions",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ActionDTO> updateAction(@Valid @RequestBody ActionDTO actionDTO) throws URISyntaxException {
        log.debug("REST request to update Action : {}", actionDTO);
        if (actionDTO.getId() == null) {
            return createAction(actionDTO);
        }
        ActionDTO result = actionService.save(actionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("action", actionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /actions -> get all the actions.
     */
    @RequestMapping(value = "/actions",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<ActionDTO>> getAllActions(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Actions");
        Page<Action> page = actionService.findByUserConnected(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/actions");
        return new ResponseEntity<>(page.getContent().stream()
            .map(actionMapper::actionToActionDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /actions/:id -> get the "id" action.
     */
    @RequestMapping(value = "/actions/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<ActionDTO> getAction(@PathVariable Long id) {
        log.debug("REST request to get Action : {}", id);
        ActionDTO actionDTO = actionService.findOne(id);
        return Optional.ofNullable(actionDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /actions/:id -> delete the "id" action.
     */
    @RequestMapping(value = "/actions/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteAction(@PathVariable Long id) {
        log.debug("REST request to delete Action : {}", id);
        actionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("action", id.toString())).build();
    }

    /**
     * SEARCH  /_search/actions/:query -> search for the action corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/actions/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<ActionDTO> searchActions(@PathVariable String query) {
        log.debug("Request to search Actions for query {}", query);
        return actionService.search(query);
    }
}
