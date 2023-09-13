package br.com.clientes.apiclientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // substitui o WebSecurityCoinfirerAdapter e tem um desaclopamento melhor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    //Filtros
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.
                authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/v1/cliente").permitAll(); //define as rotas publicas
                            authorizeConfig.requestMatchers("/v1/cliente/deletar").hasRole("ADMIN"); //define as rotas privadas
                            authorizeConfig.anyRequest().authenticated();
                        })
                .formLogin(Customizer.withDefaults())
                .build();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin", "admin")
//                .roles("ADMIN")
//                .and()
//                .withUser("user", "new_password")
//                .roles("USER");
//    }

}
