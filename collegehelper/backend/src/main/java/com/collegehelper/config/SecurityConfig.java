package com.collegehelper.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures Spring Security for JWT and role-based protection.
 * (Production: add JWT filter, password encoder, etc.)
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth/**", "/h2-console/**").permitAll()
            .antMatchers("/api/admin/**").hasAuthority("ADMIN")
            .antMatchers("/api/mod/**").hasAnyAuthority("ADMIN", "MODERATOR")
            .antMatchers("/api/student/**").hasAnyAuthority("ADMIN", "MODERATOR", "STUDENT")
            .anyRequest().authenticated()
            .and().headers().frameOptions().disable();
        return http.build();
    }
}
