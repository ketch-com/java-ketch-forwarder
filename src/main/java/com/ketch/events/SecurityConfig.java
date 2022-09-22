package com.ketch.events;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().realmName("ketch").and().authorizeHttpRequests().anyRequest().authenticated();
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        val username = System.getenv("KETCH_USER_NAME");
        val password = System.getenv("KETCH_USER_PASSWORD");
        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        val user = User.builder()
                .passwordEncoder(encoder::encode)
                .username(username)
                .password(password)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
