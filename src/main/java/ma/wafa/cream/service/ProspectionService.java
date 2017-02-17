package ma.wafa.cream.service;

import java.util.List;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.web.rest.dto.ProspectImportDTO;
import ma.wafa.cream.web.rest.dto.ProspectionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Prospection.
 */
public interface ProspectionService {

    /**
     * Save a prospection.
     * @return the persisted entity
     */
    public ProspectionDTO save(ProspectionDTO prospectionDTO);

    /**
     *  get all the prospections.
     *  @return the list of entities
     */
    public Page<Prospection> findAll(Pageable pageable);

    /**
     *  get the "id" prospection.
     *  @return the entity
     */
    public ProspectionDTO findOne(Long id);

    /**
     *  delete the "id" prospection.
     */
    public void delete(Long id);

    /**
     * search for the prospection corresponding
     * to the query.
     */
    public List<ProspectionDTO> search(String query);

	void importProspect(List<ProspectImportDTO> listProspectDto, Long compagneId);

	Page<Prospection> findByStatutAQualifieEtNonAffecter(Pageable pageable);

    Page<Prospection> findByStatutAQualifie(String user, Pageable pageable);

    Page<Prospection> findByUser(String user, Pageable pageable);
}
