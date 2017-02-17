package ma.wafa.cream.repository;

import ma.wafa.cream.domain.Action;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.Tache;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Action entity.
 */
public interface ActionRepository extends JpaRepository<Action,Long> {

	Page<Action> findByUser(String currentUserLogin, Pageable pageable);
}
