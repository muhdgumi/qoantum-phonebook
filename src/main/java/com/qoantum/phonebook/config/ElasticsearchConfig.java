package com.qoantum.phonebook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Elasticsearch configuration
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.qoantum.phonebook"})
public class ElasticsearchConfig {
}
