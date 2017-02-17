package ma.wafa.cream.repository;

import ma.wafa.cream.domain.RefSecteurActivite;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the RefSecteurActivite entity.
 */
public interface RefSecteurActiviteRepository extends JpaRepository<RefSecteurActivite,Long> {

}
