package ma.wafa.cream.service;

import java.util.List;

import ma.wafa.cream.web.rest.dto.EventDTO;

/**
 * Service Interface for managing Event.
 */

public interface EventService {
    /**
     *  get all the actions.
     *  @return the list of entities
     */

    public  List<EventDTO> findByUserConnected();


	public EventDTO update(EventDTO eventDTO);
}
