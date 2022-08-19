package br.com.wmoddev.bookstore.config.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.wmoddev.bookstore.config.database.util.DatabaseUtil;

@Configuration
public class DatabaseConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);
	
	private final DatabaseUtil dbUtil;
	
    public DatabaseConfig(final DatabaseUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Profile("dev")
    @Bean
    String testDatabaseConnection() {
		LOGGER.info("DB connection for DEV - Postgresql");
		LOGGER.info(dbUtil.getDriverClassName());
		LOGGER.info(dbUtil.getUrl());
        return "DB Connection to Postgresql_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    String prodDatabaseConnection() {
    	LOGGER.info("DB connection for Postgresql Database: production");
		LOGGER.info(dbUtil.getDriverClassName());
		LOGGER.info(dbUtil.getUrl());
        return "DB Connection to Postgresql production - Test instance";
    }

}
