package com.lix.java_flower_app.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (use in production with care)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/products/**").hasRole("ADMIN")  // Restrict product-related operations to ADMIN
                        .anyRequest().permitAll()  // Allow all other routes for any user
                )
                .httpBasic(httpBasic -> {});  // Basic authentication configuration

        return http.build();
    }
}
