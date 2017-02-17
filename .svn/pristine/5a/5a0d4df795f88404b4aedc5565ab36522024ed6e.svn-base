package ma.wafa.cream.repository;

import java.util.List;

import ma.wafa.cream.domain.Agent;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Agent entity.
 */
public interface AgentRepository extends JpaRepository<Agent, String> {
    List<Agent> findByManagerCommercialJunior(String managerCommercialJunior);
}
