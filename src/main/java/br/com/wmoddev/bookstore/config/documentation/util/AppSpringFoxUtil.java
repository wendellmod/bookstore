package br.com.wmoddev.bookstore.config.documentation.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@ConfigurationProperties("app.api")
public class AppSpringFoxUtil {
	
	private String title;
	private String version;
	private String description;
	private String basePackage;

}
