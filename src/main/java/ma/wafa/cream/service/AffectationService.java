package ma.wafa.cream.service;

import ma.wafa.cream.domain.Prospection;

/**
 * Service Interface for Affectation.
 */
public interface AffectationService {

    /**
     * Affectation d'une prospection à un agent.
     */
    public void dispatch(Prospection prospection);

    void affecter(String user, Prospection prospection);
}
