package ma.wafa.cream.web.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import ma.wafa.cream.service.EventService;
import ma.wafa.cream.web.rest.dto.EventDTO;
import ma.wafa.cream.web.rest.dto.TacheDTO;
import ma.wafa.cream.web.rest.util.HeaderUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing RefStatutTache.
 */
@RestController
@RequestMapping("/api")
public class EventResource {

    private final Logger log = LoggerFactory.getLogger(EventResource.class);
        
    @Inject
    private EventService eventService;
    
    @RequestMapping(value = "/events",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
        @Timed
        public List<EventDTO> findEvent() {
            
    	log.debug("Request to find all event for user connected ");
            
            
            return eventService.findByUserConnected();
        }
    
   
    /**
     * PUT  /taches -> Updates an existing tache.
     */
    @RequestMapping(value = "/events",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EventDTO> updateEvent(@Valid @RequestBody EventDTO eventDTO) throws URISyntaxException {
        log.debug("REST request to update Event : {}", eventDTO);
        
                        
        EventDTO result = eventService.update(eventDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("Event", result.getId().toString()))
            .body(result);
    }
}
