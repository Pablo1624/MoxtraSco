package com.example.moxtra.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Creates the necessary objects to configure Springdoc OpenAPI. OpenAPI
 * automates the generation of API documentation using spring boot projects This
 * class only will be loaded with Non production profile.
 *
 * @author Santander Tecnología
 */
@Configuration
public class SwaggerConfig {

	/**
	 * Creates Springdoc object where the API Documentation is grouped by package
	 * and path pattern
	 *
	 * @return GroupedOpenApi grouped open api
	 */
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("api-web").packagesToScan("com.example.moxtra.controller").build();
	}

	/**
	 * Creates Springdoc object where it is defined or described the API definition.
	 *
	 * @return OpenAPI open api
	 */
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI()
				.info(new Info().title("Moxtra")
						.description("Application Java - Spring Boot. Reverse Mortgage Project - Moxtra")
						.version("1.0.0-SNAPSHOT"))
				.components(new Components().addSecuritySchemes("BearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.addSecurityItem(new SecurityRequirement().addList("BearerAuth"));
	}
}
