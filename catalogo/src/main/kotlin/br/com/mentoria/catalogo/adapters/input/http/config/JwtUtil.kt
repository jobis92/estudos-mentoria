package br.com.mentoria.catalogo.adapters.input.http.config

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

    fun generateToken(username: String, roles: List<String>): String {
        return Jwts.builder()
            .setSubject(username)
            .claim("roles", roles) // 👈 adiciona as roles como claim
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60))
            .signWith(key, SignatureAlgorithm.HS512)
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

    fun extractRoles(token: String): List<String> {
        val claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body

        val roles = claims["roles"]
        return when (roles) {
            is List<*> -> roles.filterIsInstance<String>()
            else -> emptyList()
        }
    }


}