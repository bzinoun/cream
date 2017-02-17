package ma.wafa.cream.repository;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutProspection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Prospection entity.
 */
public interface ProspectionRepository extends JpaRepository<Prospection,Long> {

	Page<Prospection> findByUser(String currentUserLogin, Pageable pageable);
	Page<Prospection> findByStatutProspectionAndUserIsNull(RefStatutProspection statutProspectioné, Pageable pageable);
	
	Page<Prospection> findByAccessUser(String user, Pageable pageable);
    Page<Prospection> findByUserAndStatutProspection(String user, RefStatutProspection statutProspection, Pageable pageable);
}
