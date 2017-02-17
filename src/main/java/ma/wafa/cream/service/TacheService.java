package ma.wafa.cream.service;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.web.rest.dto.ActionDTO;
import ma.wafa.cream.web.rest.dto.TacheDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Tache.
 */
public interface TacheService {

    /**
     * Save a tache.
     * @return the persisted entity
     */
    public TacheDTO save(TacheDTO tacheDTO);

    /**
     *  get all the taches.
     *  @return the list of entities
     */
    public Page<Tache> findAll(Pageable pageable);

    /**
     *  get the "id" tache.
     *  @return the entity
     */
    public TacheDTO findOne(Long id);

    /**
     *  delete the "id" tache.
     */
    public void delete(Long id);

    /**
     * search for the tache corresponding
     * to the query.
     */
    public List<TacheDTO> search(String query);

    public Page<Tache> findByUserConnected(Pageable pageable);

	public List<ActionDTO> findActions(Long id);

	public Page<Tache> findLastNbrTache(int nbr);

	public List<TacheDTO> findByStatutTacheAndUserAndProspection(
			RefStatutTache refStatutTache, Prospection prospection);

	public List<TacheDTO> findAPlanifier();
}
