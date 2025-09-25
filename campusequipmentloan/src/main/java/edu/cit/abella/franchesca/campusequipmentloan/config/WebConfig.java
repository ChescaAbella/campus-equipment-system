package edu.cit.abella.franchesca.campusequipmentloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebConfig {

        @Bean
        public SercurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception{

        }
}
