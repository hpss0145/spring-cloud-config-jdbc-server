package com.cloud.jdbc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigJdbcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigJdbcServerApplication.class, args);
	}

}
