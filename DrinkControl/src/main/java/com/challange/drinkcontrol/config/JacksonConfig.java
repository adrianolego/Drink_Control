package com.challange.drinkcontrol.config;

import com.challange.drinkcontrol.domain.AlcoholicDrink;
import com.challange.drinkcontrol.domain.NonAlcoholicDrink;
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
                objectMapper.registerSubtypes(AlcoholicDrink.class);
                objectMapper.registerSubtypes(NonAlcoholicDrink.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }
}
