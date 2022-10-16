package com.example.requestprocessingservice.elasticrepository;

import com.example.requestprocessingservice.model.ElasticRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestElasticRepository extends ElasticsearchRepository<ElasticRequest, Long> {
    ElasticRequest findByText(String text);
}
