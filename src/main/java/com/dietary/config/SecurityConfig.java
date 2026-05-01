package com.dietary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // 🔑 Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔐 Security Configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // disable CSRF

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/api/auth/**").permitAll() // ✅ allow homepage + auth APIs
                .anyRequest().authenticated() // protect everything else
            )

            .httpBasic(httpBasic -> httpBasic.disable()) // ❌ remove popup
            .formLogin(form -> form.disable()); // ❌ remove login page

        return http.build();
    }
}