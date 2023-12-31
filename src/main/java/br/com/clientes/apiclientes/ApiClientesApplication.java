package br.com.clientes.apiclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ConfigurationPropertiesScan
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class ApiClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClientesApplication.class, args);
	}

}
