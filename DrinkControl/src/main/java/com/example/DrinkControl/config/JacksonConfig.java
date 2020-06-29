package com.example.DrinkControl.config;

import com.example.DrinkControl.domain.DrinkAlcoholic;
import com.example.DrinkControl.domain.DrinkNonAlcoholic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(DrinkAlcoholic.class);
                objectMapper.registerSubtypes(DrinkNonAlcoholic.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }
}
