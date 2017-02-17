package ma.wafa.cream.service;

import ma.wafa.cream.domain.Personne;
import ma.wafa.cream.web.rest.dto.PersonneDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Personne.
 */
public interface PersonneService {

    /**
     * Save a personne.
     * @return the persisted entity
     */
    public PersonneDTO save(PersonneDTO personneDTO);

    /**
     *  get all the personnes.
     *  @return the list of entities
     */
    public Page<Personne> findAll(Pageable pageable);

    /**
     *  get the "id" personne.
     *  @return the entity
     */
    public PersonneDTO findOne(Long id);

    /**
     *  delete the "id" personne.
     */
    public void delete(Long id);

    /**
     * search for the personne corresponding
     * to the query.
     */
    public List<PersonneDTO> search(String query);
}
