package org.sbl.sblearning01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Sblearning01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Sblearning01Application.class, args);
		System.out.println("Hello Spring Boot app");
	}

}
