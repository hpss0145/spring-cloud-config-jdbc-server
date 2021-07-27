package com.cloud.jdbc.config.custom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import({CustomJdbcRepositoryConfiguration.class})
public class CustomEnvironmentRepositoryConfiguration{
}

@Configuration
@ConditionalOnProperty(value = "spring.cloud.config.server.jdbc.enabled", matchIfMissing = true)
class CustomJdbcRepositoryConfiguration {

    @Bean
    @Primary
    @ConditionalOnBean(JdbcTemplate.class)
    public JdbcEnvironmentRepository customJdbcEnvironmentRepository(CustomJdbcEnvironmentRepositoryFactory factory,
                                                               JdbcEnvironmentProperties environmentProperties) {
        return factory.build(environmentProperties);
    }
}
