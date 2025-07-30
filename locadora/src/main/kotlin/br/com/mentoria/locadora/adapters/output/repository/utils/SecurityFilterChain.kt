package br.com.mentoria.locadora.adapters.output.repository.utils

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/h2-console/**").permitAll() // Libera acesso ao H2 Console
                    .requestMatchers("/catalogos/**").permitAll() // Libera acesso ao H2 Console
                    .anyRequest().authenticated() // Protege os demais endpoints
            }
            .csrf { csrf ->
                csrf.disable() // Desativa proteção CSRF para permitir uso do console H2
            }
            .headers { headers ->
                headers.frameOptions { frameOptions ->
                    frameOptions.disable() // Permite o uso de frames no navegador (necessário para o H2 Console)
                }
            }

        return http.build()
    }
}