package br.com.boletojuros.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI custonOpenApi() {
		return new OpenAPI().info(new Info()
				.title("API juros boleto")
				.description("Api para calcular juros de boleto vendico")
				.contact(new Contact()
						.name("Rodrigo Fernandes")
						.email("rodrigo.fer.....@hotmail.com"))
				.version("1.0.0"));
	}

}
