package com.rollerspeed.v1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests()
                .requestMatchers("/v1/index/", "/swagger-ui/index.html", "/swagger-ui.html").permitAll()
                .requestMatchers("/students/listar").authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .build();
    }
}
