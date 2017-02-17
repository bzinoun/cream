package ma.wafa.cream.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import ma.wafa.cream.domain.Access;
import ma.wafa.cream.domain.Agence;
import ma.wafa.cream.domain.Prospection;
import ma.wafa.cream.domain.RefStatutProspection;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.domain.enumeration.TypeTache;
import ma.wafa.cream.repository.AgenceRepository;
import ma.wafa.cream.repository.ProspectionRepository;
import ma.wafa.cream.repository.RefStatutProspectionRepository;
import ma.wafa.cream.repository.RefStatutTacheRepository;
import ma.wafa.cream.repository.RepositoryConstants;
import ma.wafa.cream.repository.TacheRepository;
import ma.wafa.cream.service.AffectationService;
import ma.wafa.cream.service.OrganisationService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Service Implementation for Affectation.
 */
@Service
@Transactional
public class AffectationServiceImpl implements AffectationService {
    
    private final Logger log = LoggerFactory.getLogger(AffectationServiceImpl.class);
    
    @Inject
    private TacheRepository tacheRepository;
    
    @Inject
    private ProspectionRepository prospectionRepository;
    
    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;
    
    @Inject
    private RefStatutProspectionRepository refStatutProspectionRepository;
    
    @Inject
    private OrganisationService organisationService;
    
    @Inject
    private AgenceRepository agenceRepository;
    
    @Override
    public void dispatch(Prospection prospection) {
        String codeAgent = null;
        
        String codeAgence = prospection.getPersonne().getCodeAgence();
        
        if (!StringUtils.isBlank(codeAgence)) {
            // Si on a le code agence
            Agence agence = agenceRepository.findByCodeAgence(codeAgence);
            codeAgent = agence.getCodeAgent();
        } else {
            // / TODO : "Round robin ///";
        }
        
        if (codeAgent != null) {
            affecter(codeAgent, prospection);
        }
    }
    
    @Override
    public void affecter(String user, Prospection prospection) {
        Assert.hasText(user, "Le code agent ne doit pas etre null");
        
        RefStatutProspection encoursStatus = refStatutProspectionRepository
                .findByCode(RepositoryConstants.REF_STATUT_PROSPECTION_EN_COURS_CODE);
        
        prospection.setUser(user);
        
        setAccess(prospection, user);
        prospection.setStatutProspection(encoursStatus);
        
        prospectionRepository.save(prospection);
        log.info("Affectation : Prospect = {} to Agent = {}.", prospection.getPersonne().getNom(), prospection.getUser());
        // TODO : Gerer l'historique (priorité basse)
        
        Tache tache = new Tache();
        
        LocalDate dateEcheance = prospection.getDateEcheance();
        // TODO : S'assurer de la RG
        tache.setDateDebut(dateEcheance != null ? dateEcheance.minusDays(15) : LocalDate.now());
        
        tache.setProspection(prospection);
        tache.setUser(prospection.getUser());
        tache.setStatutTache(refStatutTacheRepository.findByCode(RepositoryConstants.REF_STATUT_TACHE_EN_COURS_CODE));
        tache.setType(TypeTache.TRAITEMENT_PROSPECT);
        tache.setSujet(String.format("Traitement du prospect : %s %s", prospection.getPersonne().getNom(), prospection.getPersonne()
                .getPrenom()));
        
        tacheRepository.save(tache);
    }
    
    private void setAccess(Prospection prospection, String user) {
        prospection.getAccess().clear();
        
        List<String> accessors = organisationService.getManagers(user);
        
        accessors.add(user);
        
        accessors.forEach(e -> {
            Access a = new Access();
            a.setUser(e);
            prospection.getAccess().add(a);
        });
    }
    
}
