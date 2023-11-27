package com.example.msassignment.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {
    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    public GlobalSecurityConfiguration(TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> {
            authorizeHttpRequests
                    .requestMatchers(HttpMethod.POST, "api/v1/assignment").hasRole("CREATE-COURSES")
                    .requestMatchers(HttpMethod.PUT, "api/v1/assignment/{id}/user/{userId}").hasRole("VIEW-CONTENT")
                    .requestMatchers(HttpMethod.POST, "api/v1/assignment/{assignmentId}").hasRole("VIEW-CONTENT")
                    .requestMatchers(HttpMethod.GET, "api/v1/assignment/all/{courseId}").hasAnyRole("VIEW-CONTENT", "CREATE-COURSES")
                    .requestMatchers(HttpMethod.GET, "api/v1/assignment-type").hasAnyRole("VIEW-CONTENT", "CREATE-COURSES")



                    .anyRequest().permitAll();
                    //.requestMatchers("/**").permitAll();
            //.anyRequest().permitAll();
        });
        http.oauth2ResourceServer((oauth2) -> {
            oauth2.jwt((jwt) -> jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter));
        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(withDefaults());
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}

