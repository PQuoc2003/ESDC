package com.hyperion.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Lab06Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab06Application.class, args);
	}

}
