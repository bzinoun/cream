package ma.wafa.cream.repository.search;

import ma.wafa.cream.domain.RefSituationFamiliale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the RefSituationFamiliale entity.
 */
public interface RefSituationFamilialeSearchRepository extends ElasticsearchRepository<RefSituationFamiliale, Long> {
}
