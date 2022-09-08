package com.stefanini.librarybackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class represents cors configuration.
 * Configuration allows the front to use the api of this application.
 *
 * @author dcuiuc
 */
@Configuration
@EnableWebMvc
public class CorsConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Value("${cors.allowed.origins}")
    String allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "PUT", "POST", "DELETE")
                .allowedOrigins(allowedOrigins)
                .exposedHeaders("Authorization")
                .allowedHeaders("*");
    }
}
