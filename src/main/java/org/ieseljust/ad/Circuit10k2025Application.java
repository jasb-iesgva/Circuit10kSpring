package org.ieseljust.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class Circuit10k2025Application {

	public static void main(String[] args) {
		SpringApplication.run(Circuit10k2025Application.class, args);
	}

}
