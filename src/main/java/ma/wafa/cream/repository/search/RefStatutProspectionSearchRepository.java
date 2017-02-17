package ma.wafa.cream.repository.search;

import ma.wafa.cream.domain.RefStatutProspection;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the RefStatutProspection entity.
 */
public interface RefStatutProspectionSearchRepository extends ElasticsearchRepository<RefStatutProspection, Long> {
}
