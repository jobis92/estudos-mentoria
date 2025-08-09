package br.com.mentoria.catalogo.adapters.input.http.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class UserConfig {

    @Bean
    fun userDetailsService(): UserDetailsService {

        try {
        val user = User.withUsername("john")
            .password(passwordEncoder().encode("teste"))
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user)
        }catch (ex:UsernameNotFoundException){
            throw ex
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}