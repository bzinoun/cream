package ma.wafa.cream.repository.search;

import ma.wafa.cream.domain.RefStatutCompagne;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the RefStatutCompagne entity.
 */
public interface RefStatutCompagneSearchRepository extends ElasticsearchRepository<RefStatutCompagne, Long> {
}
