package com.example.Proyecto_Final_Progra3.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        return http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth ->auth
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/empresas/**").hasRole("EMPRESA")
                    .requestMatchers("/freelancers/**","/empleado/**").hasRole("EMPLOYEE")
                    .requestMatchers("/recruiters/**").hasRole("RECRUITER")
                    .requestMatchers("/instructors/**").hasRole("INSTRUCTOR")
                    .requestMatchers("/clientes/**").hasRole("CLIENTE")
            ).build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
