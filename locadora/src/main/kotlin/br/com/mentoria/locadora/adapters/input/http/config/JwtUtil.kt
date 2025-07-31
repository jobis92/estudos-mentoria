package br.com.mentoria.locadora.adapters.input.http.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtil(
    @Value("\${jwt.secret}") private val secret: String
) {

    private val key = SecretKeySpec(secret.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.jcaName)

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
            .signWith(key, SignatureAlgorithm.HS512) // 👈 importante: especificar algoritmo
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            println("Token inválido: ${e.message}") // 👈 ajuda no debug
            false
        }
    }

    fun extractUsername(token: String): String {
        val claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
        return claims.body.subject
    }
}