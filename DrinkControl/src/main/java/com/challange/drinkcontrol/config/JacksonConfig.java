package com.challange.drinkcontrol.config;

import com.challange.drinkcontrol.domain.AlcoholicDrinkBatch;
import com.challange.drinkcontrol.domain.NonAlcoholicDrinkBatch;
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
                objectMapper.registerSubtypes(AlcoholicDrinkBatch.class);
                objectMapper.registerSubtypes(NonAlcoholicDrinkBatch.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }
}
