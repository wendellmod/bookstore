package br.com.wmoddev.bookstore.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.wmoddev.bookstore.config.database.util.DatabaseUtil;

@Configuration
public class DatabaseConfig {
	
	private final DatabaseUtil dbUtil;
	
    public DatabaseConfig(final DatabaseUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
    
    // TODO: Substituir sysout por log

	@Profile("dev")
    @Bean
    String testDatabaseConnection() {
        System.out.println("DB connection for DEV - Postgresql");
        System.out.println(dbUtil.getDriverClassName());
        System.out.println(dbUtil.getUrl());
        return "DB Connection to Postgresql_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    String prodDatabaseConnection() {
        System.out.println("DB connection for Postgresql Database: production");
        System.out.println(dbUtil.getDriverClassName());
        System.out.println(dbUtil.getUrl());
        return "DB Connection to Postgresql production - Test instance";
    }

}
