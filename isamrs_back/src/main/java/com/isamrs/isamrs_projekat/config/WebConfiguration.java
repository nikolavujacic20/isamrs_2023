package com.isamrs.isamrs_projekat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    // Za svrhe razvoja konfigurisemo dozvolu za CORS kako ne bismo morali @CrossOrigin anotaciju da koristimo nad svakim kontrolerom
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/**").allowedOrigins("*");
        registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST","PATCH", "PUT", "DELETE", "OPTIONS");
    }
}
