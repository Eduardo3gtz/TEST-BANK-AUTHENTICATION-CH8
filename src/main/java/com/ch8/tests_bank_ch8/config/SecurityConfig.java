package com.ch8.tests_bank_ch8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactivamos CSRF para poder hacer POST en tests y Postman sin token
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // Permitimos sin autenticación nuestros endpoints de pruebas
                        .requestMatchers("/api/**", "/h2-console/**").permitAll()
                        .anyRequest().permitAll()
                )
                // Para que la consola H2 funcione en navegador
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
