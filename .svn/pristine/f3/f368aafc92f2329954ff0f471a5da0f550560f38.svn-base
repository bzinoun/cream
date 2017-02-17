package ma.wafa.cream.service;

import ma.wafa.cream.domain.Action;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Action.
 */
public interface ActionService {

    /**
     * Save a action.
     * @return the persisted entity
     */
    public ActionDTO save(ActionDTO actionDTO);

    /**
     *  get all the actions.
     *  @return the list of entities
     */
    public Page<Action> findAll(Pageable pageable);

    /**
     *  get the "id" action.
     *  @return the entity
     */
    public ActionDTO findOne(Long id);

    /**
     *  delete the "id" action.
     */
    public void delete(Long id);

    /**
     * search for the action corresponding
     * to the query.
     */
    public List<ActionDTO> search(String query);

    public  Page<Action> findByUserConnected(Pageable pageable);
}
