package ma.wafa.cream.service;

import com.codahale.metrics.annotation.Timed;
import ma.wafa.cream.domain.*;
import ma.wafa.cream.repository.*;
import ma.wafa.cream.repository.search.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ElasticsearchIndexService {

    private final Logger log = LoggerFactory.getLogger(ElasticsearchIndexService.class);

    @Inject
    private ActionRepository actionRepository;

    @Inject
    private ActionSearchRepository actionSearchRepository;

    @Inject
    private ClientRepository clientRepository;

    @Inject
    private ClientSearchRepository clientSearchRepository;

    @Inject
    private CompagneRepository compagneRepository;

    @Inject
    private CompagneSearchRepository compagneSearchRepository;

    @Inject
    private PerferenceRepository perferenceRepository;

    @Inject
    private PerferenceSearchRepository perferenceSearchRepository;

    @Inject
    private PersonneRepository personneRepository;

    @Inject
    private PersonneSearchRepository personneSearchRepository;

    @Inject
    private ProspectionRepository prospectionRepository;

    @Inject
    private ProspectionSearchRepository prospectionSearchRepository;

    @Inject
    private RefSecteurActiviteRepository refSecteurActiviteRepository;

    @Inject
    private RefSecteurActiviteSearchRepository refSecteurActiviteSearchRepository;

    @Inject
    private RefSituationFamilialeRepository refSituationFamilialeRepository;

    @Inject
    private RefSituationFamilialeSearchRepository refSituationFamilialeSearchRepository;

    @Inject
    private RefStatutCompagneRepository refStatutCompagneRepository;

    @Inject
    private RefStatutCompagneSearchRepository refStatutCompagneSearchRepository;

    @Inject
    private RefStatutProspectionRepository refStatutProspectionRepository;

    @Inject
    private RefStatutProspectionSearchRepository refStatutProspectionSearchRepository;

    @Inject
    private RefStatutTacheRepository refStatutTacheRepository;

    @Inject
    private RefStatutTacheSearchRepository refStatutTacheSearchRepository;

    @Inject
    private TacheRepository tacheRepository;

    @Inject
    private TacheSearchRepository tacheSearchRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserSearchRepository userSearchRepository;

    @Inject
    private ElasticsearchTemplate elasticsearchTemplate;

    @Async
    @Timed
    public void reindexAll() {
        elasticsearchTemplate.deleteIndex(Action.class);
        if (actionRepository.count() > 0) {
            actionSearchRepository.save(actionRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all actions");

        elasticsearchTemplate.deleteIndex(Client.class);
        if (clientRepository.count() > 0) {
            clientSearchRepository.save(clientRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all clients");

        elasticsearchTemplate.deleteIndex(Compagne.class);
        if (compagneRepository.count() > 0) {
            compagneSearchRepository.save(compagneRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all compagnes");

        elasticsearchTemplate.deleteIndex(Perference.class);
        if (perferenceRepository.count() > 0) {
            perferenceSearchRepository.save(perferenceRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all perferences");

        elasticsearchTemplate.deleteIndex(Personne.class);
        if (personneRepository.count() > 0) {
            personneSearchRepository.save(personneRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all personnes");

        elasticsearchTemplate.deleteIndex(Prospection.class);
        if (prospectionRepository.count() > 0) {
            prospectionSearchRepository.save(prospectionRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all prospections");

        elasticsearchTemplate.deleteIndex(RefSecteurActivite.class);
        if (refSecteurActiviteRepository.count() > 0) {
            refSecteurActiviteSearchRepository.save(refSecteurActiviteRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all refSecteurActivites");

        elasticsearchTemplate.deleteIndex(RefSituationFamiliale.class);
        if (refSituationFamilialeRepository.count() > 0) {
            refSituationFamilialeSearchRepository.save(refSituationFamilialeRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all refSituationFamiliales");

        elasticsearchTemplate.deleteIndex(RefStatutCompagne.class);
        if (refStatutCompagneRepository.count() > 0) {
            refStatutCompagneSearchRepository.save(refStatutCompagneRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all refStatutCompagnes");

        elasticsearchTemplate.deleteIndex(RefStatutProspection.class);
        if (refStatutProspectionRepository.count() > 0) {
            refStatutProspectionSearchRepository.save(refStatutProspectionRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all refStatutProspections");

        elasticsearchTemplate.deleteIndex(RefStatutTache.class);
        if (refStatutTacheRepository.count() > 0) {
            refStatutTacheSearchRepository.save(refStatutTacheRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all refStatutTaches");

        elasticsearchTemplate.deleteIndex(Tache.class);
        if (tacheRepository.count() > 0) {
            tacheSearchRepository.save(tacheRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all taches");

        elasticsearchTemplate.deleteIndex(User.class);
        if (userRepository.count() > 0) {
            userSearchRepository.save(userRepository.findAll());
        }
        log.info("Elasticsearch: Indexed all users");

        log.info("Elasticsearch: Successfully performed reindexing");
    }
}
