package br.com.clientes.apiclientes.config.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Autowired
    public ObjectMapper objectMapper;

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }


}