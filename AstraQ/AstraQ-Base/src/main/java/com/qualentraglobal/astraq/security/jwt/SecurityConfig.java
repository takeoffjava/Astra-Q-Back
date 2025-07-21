package com.qualentraglobal.astraq.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 return http.cors(cors -> cors.disable())
				 .csrf(csrf -> csrf.disable())
				 .authorizeHttpRequests(auth -> auth
						 .requestMatchers("/astraq/api/v1/login").permitAll()
						 .anyRequest().authenticated()
				 )
				 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				 .build();

	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
}