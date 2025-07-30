package com.ipartek.formacion.ejemplospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance(); //new BCryptPasswordEncoder();
	}
}
