package br.com.mentoria.locadora.adapters.input.http.controller

import br.com.mentoria.locadora.adapters.input.http.config.JwtUtil
import org.springframework.http.ResponseEntity
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
        val authentication = authenticationManager.authenticate(authToken)

        val userDetails = authentication.principal as org.springframework.security.core.userdetails.User
        val roles = userDetails.authorities.map { it.authority.removePrefix("ROLE_") }

        val token = jwtUtil.generateToken(userDetails.username, roles)
        return AuthResponse(token)
    }

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        val auth = SecurityContextHolder.getContext().authentication
        return ResponseEntity.ok("Usuário: ${auth?.name}, Roles: ${auth?.authorities}")
    }

}

data class AuthRequest(val username: String, val password: String)
data class AuthResponse(val token: String)