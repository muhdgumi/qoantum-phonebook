package com.qoantum.phonebook.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * Spring data jpa repository configuration
 */
@Component
@Configuration
@EntityScan(basePackages = {RepositoryConfig.ENTITY_BASE})
@EnableJpaRepositories(basePackages = {RepositoryConfig.REPOSITORY_BASE})
public class RepositoryConfig {

    public static final String REPOSITORY_BASE = "com.qoantum.phonebook";
    public static final String ENTITY_BASE = "com.qoantum.phonebook.orm";
}
