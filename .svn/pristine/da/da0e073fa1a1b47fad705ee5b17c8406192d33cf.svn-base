package ma.wafa.cream.service;

import ma.wafa.cream.domain.Compagne;
import ma.wafa.cream.web.rest.dto.CompagneDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Compagne.
 */
public interface CompagneService {

    /**
     * Save a compagne.
     * @return the persisted entity
     */
    public CompagneDTO save(CompagneDTO compagneDTO);

    /**
     *  get all the compagnes.
     *  @return the list of entities
     */
    public Page<Compagne> findAll(Pageable pageable);

    /**
     *  get the "id" compagne.
     *  @return the entity
     */
    public CompagneDTO findOne(Long id);

    /**
     *  delete the "id" compagne.
     */
    public void delete(Long id);

    /**
     * search for the compagne corresponding
     * to the query.
     */
    public List<CompagneDTO> search(String query);
}
