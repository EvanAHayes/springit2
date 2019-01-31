package com.ehayes.springit2;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//let spring know there is a properties file
public class Springit2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springit2Application.class, args);
	}

	@Bean
	PrettyTime prettyTime() {
		return new PrettyTime();
	}

}

