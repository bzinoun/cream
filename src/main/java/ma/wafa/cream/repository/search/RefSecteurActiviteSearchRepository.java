package ma.wafa.cream.repository.search;

import ma.wafa.cream.domain.RefSecteurActivite;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the RefSecteurActivite entity.
 */
public interface RefSecteurActiviteSearchRepository extends ElasticsearchRepository<RefSecteurActivite, Long> {
}
