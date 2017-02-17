package ma.wafa.cream.repository;

import java.util.List;

import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutTache;
import ma.wafa.cream.domain.Tache;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Tache entity.
 */
public interface TacheRepository extends JpaRepository<Tache,Long> {

	Page<Tache> findByUser(String currentUserLogin, Pageable pageable);
	List<Tache> findByUser(String currentUserLogin);
	List<Tache> findByStatutTacheAndUser(RefStatutTache refStatutTache , String user );
	List<Tache> findByStatutTacheCodeAndUser(String code,String user);
	
	Page<Tache> findByStatutTacheAndUser(RefStatutTache refStatutTache , String user , Pageable pageable );
	List<Tache> findByStatutTacheAndUserAndProspection(RefStatutTache refStatutTache , String user , Prospection prospection) ; 
}
