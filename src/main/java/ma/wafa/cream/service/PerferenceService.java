package ma.wafa.cream.service;

import ma.wafa.cream.domain.Perference;
import ma.wafa.cream.web.rest.dto.PerferenceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Perference.
 */
public interface PerferenceService {

    /**
     * Save a perference.
     * @return the persisted entity
     */
    public PerferenceDTO save(PerferenceDTO perferenceDTO);

    /**
     *  get all the perferences.
     *  @return the list of entities
     */
    public Page<Perference> findAll(Pageable pageable);

    /**
     *  get the "id" perference.
     *  @return the entity
     */
    public PerferenceDTO findOne(Long id);

    /**
     *  delete the "id" perference.
     */
    public void delete(Long id);

    /**
     * search for the perference corresponding
     * to the query.
     */
    public List<PerferenceDTO> search(String query);
}
