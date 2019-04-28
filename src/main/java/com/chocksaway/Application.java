package com.chocksaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Author milesd on 27/04/2019.
 */
@SpringBootApplication

public class Application {

    /*
     * Needed to avoid java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
