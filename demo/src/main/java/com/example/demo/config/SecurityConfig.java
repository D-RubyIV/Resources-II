package com.example.demo.config;

import com.example.demo.config.jwt.JwtEntryPoint;
import com.example.demo.config.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);
        http.sessionManagement(ss -> ss.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.exceptionHandling(handle -> handle.authenticationEntryPoint(jwtEntryPoint));
        http.authorizeHttpRequests(auth -> auth
                // * AUTH
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                // * OTHER
                .anyRequest().authenticated()
        );
        http.formLogin((formLogin) ->
                formLogin
                        .loginPage("/login")
                        .failureUrl("/login?failed")
                        .loginProcessingUrl("/auth/hello")
        );
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
