package com.pragati.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.pragati.spring.*"})//this is to be written so that it will scan respective packages //if we put this class in com.suraj.spring.boot it might not need scanBasePackages
@EnableJpaRepositories(basePackages ={"com.pragati.spring.*"}) //Imp for JPA
@EntityScan("com.pragati.spring.*") //Imp for Scanning entities not used earlier but now necessary
public class SpringDataRestApplication {
	// for starters we have taken care of things in Tests file so please look there for JPA 
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

}
