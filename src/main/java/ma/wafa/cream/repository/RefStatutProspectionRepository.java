package ma.wafa.cream.repository;

import ma.wafa.cream.domain.RefStatutProspection;
import ma.wafa.cream.domain.RefStatutTache;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the RefStatutProspection entity.
 */
public interface RefStatutProspectionRepository extends JpaRepository<RefStatutProspection,Long> {

	RefStatutProspection  findByCode(String code );

	
}
