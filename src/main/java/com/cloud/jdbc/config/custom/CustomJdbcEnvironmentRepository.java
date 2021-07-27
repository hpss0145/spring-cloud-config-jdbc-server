package com.cloud.jdbc.config.custom;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CustomJdbcEnvironmentRepository extends JdbcEnvironmentRepository {

    public CustomJdbcEnvironmentRepository(JdbcTemplate jdbc, JdbcEnvironmentProperties properties) {
        super(jdbc, properties);
    }
    @Override
    public Environment findOne(String application, String profile, String label) {
        /*
        Logic to run multiple JDBC queries
         */
        return super.findOne(application, profile, label);
    }
}
