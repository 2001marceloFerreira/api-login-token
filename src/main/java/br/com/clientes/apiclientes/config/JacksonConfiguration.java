package br.com.clientes.apiclientes.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JacksonConfiguration {

    private static ObjectMapper getJsonToObjectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
                )
                .featuresToEnable(
                        MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS,
                        DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,
                        JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature(),
                        JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature()
                )
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .modules(new JavaTimeModule())
                .build();
    }


    public static ObjectMapper jsonToObjectMapperBuild() {
        return JacksonConfiguration.getJsonToObjectMapper();
    }

    public static ObjectMapper ObjectToObjectMapperBuild() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .registerModule(new JavaTimeModule());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return JacksonConfiguration.getJsonToObjectMapper();
    }


}
