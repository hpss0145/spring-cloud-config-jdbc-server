package com.cloud.jdbc.config.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepositoryFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CustomJdbcEnvironmentRepositoryFactory extends JdbcEnvironmentRepositoryFactory {

    @Autowired
    private JdbcTemplate jdbc;

    public CustomJdbcEnvironmentRepositoryFactory(JdbcTemplate jdbc) {
        super(jdbc);
    }
    @Override
    public CustomJdbcEnvironmentRepository build(JdbcEnvironmentProperties environmentProperties) {
        return new CustomJdbcEnvironmentRepository(this.jdbc, environmentProperties);
    }
}
