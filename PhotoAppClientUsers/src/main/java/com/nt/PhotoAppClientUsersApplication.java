package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class PhotoAppClientUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppClientUsersApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryPass() {
		return new BCryptPasswordEncoder();
	}

}
