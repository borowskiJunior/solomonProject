package com.solomon.backend.solomonproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/") // URL patterns to apply CORS to
                .allowedOrigins("http://localhost:3000", "https://localhost:3000", "http://localhost:3001", "https://localhost:3001", "http://solomonproject.ru") // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Allowed HTTP methods
                .allowedHeaders("*"); // Allowed headers
    }
}