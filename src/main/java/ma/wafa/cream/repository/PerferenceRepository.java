package ma.wafa.cream.repository;

import ma.wafa.cream.domain.Perference;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Perference entity.
 */
public interface PerferenceRepository extends JpaRepository<Perference,Long> {

}
