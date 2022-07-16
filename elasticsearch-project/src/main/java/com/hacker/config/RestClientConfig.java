package com.hacker.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @Author: Zero
 * @Date: 2022/6/13 19:22
 * @Description:
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {
    @Autowired
    private ElasticSearchConfig elasticSearchConfig;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticSearchConfig.getAddress() + ":" + elasticSearchConfig.getPort())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
