package com.fsse2501pt.fsse2501projectbackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.GET, "/public/product/**").
                                // /public/product/** mean the path before ** do not need to be authenticated
                                permitAll().
                                anyRequest().
                                authenticated())
//                need to add requestMatcher here to allow /public not using bearerToken
                .csrf(csrf -> csrf.disable())
              .cors(Customizer.withDefaults()); // to allow pre-flight
        http
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(
                        jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(issuer))
                ));
        return http.build();
    }
}