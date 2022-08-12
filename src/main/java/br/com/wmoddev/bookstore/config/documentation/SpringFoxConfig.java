package br.com.wmoddev.bookstore.config.documentation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.wmoddev.bookstore.config.documentation.util.AppSpringFoxUtil;
import br.com.wmoddev.bookstore.config.documentation.util.ContactSpringFoxUtil;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
@ConditionalOnProperty(name = "app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
public class SpringFoxConfig {
	
	private final AppSpringFoxUtil app;
	private final ContactSpringFoxUtil contact;

	public SpringFoxConfig(final AppSpringFoxUtil app,
						   final ContactSpringFoxUtil contact) {
		this.app = app;
		this.contact = contact;
	}

	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(app.getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(app.getTitle())
				.version(app.getVersion())
				.description(app.getDescription())
				.contact(contactInfo())
				.build();
	}

	private Contact contactInfo() {
		return new Contact(contact.getName(), contact.getUrl(), contact.getEmail());
	}

}