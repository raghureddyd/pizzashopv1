package ch.tim.pizzashopv1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@OpenAPIDefinition
public class Pizzashopv1Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(Pizzashopv1Application.class, args);
	}

}
