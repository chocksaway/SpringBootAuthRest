package com.chocksaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author milesd on 27/04/2019.
 */
@SpringBootApplication

class Application {

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
