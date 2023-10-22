package com.sahay.springsecuritytutorial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
	private UserDetailsService userDetailsService;
	// ----By Default every API is Protected therefore override SecurityFilterChain
	// to Customize
	// Security for API
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/bank").permitAll();
			auth.requestMatchers("/api/users").permitAll();
			auth.anyRequest().authenticated();
		});
		// Disable CSRF
		security.csrf(csrf -> csrf.disable());
		// Enable Basic Security
		security.httpBasic(Customizer.withDefaults());
		// Enable Form Based Security
		security.formLogin(Customizer.withDefaults());
		return security.build();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
