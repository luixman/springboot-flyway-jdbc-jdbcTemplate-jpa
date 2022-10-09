package ru.springbootflywayjdbcjdbcTemplatejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.JdbcRepo;

@SpringBootApplication

public class SpringbootFlywayJdbcJdbcTemplateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFlywayJdbcJdbcTemplateJpaApplication.class, args);
	}



}
