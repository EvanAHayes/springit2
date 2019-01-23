package com.ehayes.springit2;

import com.ehayes.springit2.config.SpringitProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//let spring know there is a properties file
public class Springit2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springit2Application.class, args);
	}



}

