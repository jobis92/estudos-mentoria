package br.com.mentoria.locadora.adapters.input.http.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter

) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it
                    .requestMatchers("/h2-console/**").permitAll() // Libera acesso ao H2 Console
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/catalogos/**").authenticated()
                    .anyRequest().authenticated() // Protege os demais endpoints
            }
            .csrf { csrf ->
                csrf.disable() // Desativa proteção CSRF para permitir uso do console H2
            }
            .headers { headers ->
                headers.frameOptions { frameOptions ->
                    frameOptions.disable() // Permite o uso de frames no navegador (necessário para o H2 Console)
                }
            }.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

}