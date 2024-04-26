package com.viewnext.siraku;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class SirakuConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean

	OpenAPI openAPI() {

		return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))

				.info(new Info().title("SIRAKU API")

						.description("API REST SPRING JPA - SIRAKU")
						.contact(new Contact().name("ANDREA SIERRA, JONATHAN BECERRO"))
						.version("0.0.1"));

	}
}
