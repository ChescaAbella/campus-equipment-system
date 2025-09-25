package edu.cit.abella.franchesca.campusequipmentloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("api/users/register","/api/users/login").permitAll()
                        .requestMatchers("user-info").authenticated()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .defaultSuccessUrl("form", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/logout")
                        .permitAll()
                )
                .build();
    }
}
