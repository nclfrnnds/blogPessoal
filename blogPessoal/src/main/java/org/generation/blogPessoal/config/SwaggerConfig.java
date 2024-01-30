package org.generation.blogPessoal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Blog Pessoal")
                    .description("Projeto Blog Pessoal")
                    .version("v0.0.1")
                    .license(new License()
                        .name("Nicoli Fernandes")
                        .url("https://github.com/nic0li"))
                    .contact(new Contact()
                        .name("Nicoli Fernandes")
                        .url("https://github.com/nic0li")
                        .email("nicoli1992@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                    .description("Github")
                    .url("Nicoli Fernandes"));
	}

}
