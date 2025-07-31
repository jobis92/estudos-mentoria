package br.com.mentoria.locadora.adapters.input.http.controller

import br.com.mentoria.locadora.adapters.input.http.config.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): AuthResponse {
        val authToken = UsernamePasswordAuthenticationToken(request.username, request.password)
        authenticationManager.authenticate(authToken)
        val token = jwtUtil.generateToken(request.username)
        return AuthResponse(token)
    }


    @GetMapping("/ping")
    fun ping(): String {
        val auth = SecurityContextHolder.getContext().authentication
        return if (auth != null) {
            "Autenticado como: ${auth.name}"
        } else {
            "Não autenticado"
        }
    }

}

data class AuthRequest(val username: String, val password: String)
data class AuthResponse(val token: String)