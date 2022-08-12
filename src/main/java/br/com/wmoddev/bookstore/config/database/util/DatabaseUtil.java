package br.com.wmoddev.bookstore.config.database.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@ConfigurationProperties("spring.datasource")
public class DatabaseUtil {
	
    private String driverClassName;
    private String url;
    private String username;
    private String password;

}
