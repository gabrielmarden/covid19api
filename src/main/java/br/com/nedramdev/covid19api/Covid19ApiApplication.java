package br.com.nedramdev.covid19api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Covid19ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ApiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
				.title("COVID19 Rest API")
				.version("1.0.0")
				.description("The COVID19 RESTful API project uses a general-purpose code to focus on the management of patients with COVID 19." +
						" It helps the user to manage and monitor different stages that patients face in eventual hospitalizations.")
				.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
				.contact(new Contact()
						.name("Marden Rocha")
						.url("https://github.com/gabrielmarden")));
	}
}
