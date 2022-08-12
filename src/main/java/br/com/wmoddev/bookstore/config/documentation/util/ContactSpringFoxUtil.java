package br.com.wmoddev.bookstore.config.documentation.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@ConfigurationProperties("app.api.contact")
public class ContactSpringFoxUtil {
	
	private String name;
	private String url;
	private String email;

}
