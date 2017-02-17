package ma.wafa.cream.repository.search;

import ma.wafa.cream.domain.Action;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the Action entity.
 */
public interface ActionSearchRepository extends ElasticsearchRepository<Action, Long> {
}
