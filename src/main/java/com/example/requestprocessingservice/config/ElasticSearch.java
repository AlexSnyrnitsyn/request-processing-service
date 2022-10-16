package com.example.requestprocessingservice.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.requestprocessingservice.elasticrepository")
@ComponentScan(basePackages = { "com.example.requestprocessingservice" })
public class ElasticSearch extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.address}")
    public String address;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo(address)
                        .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
