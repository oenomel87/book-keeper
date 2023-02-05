package io.oenomel.stream.config.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import io.oenomel.stream.config.security.AuthUser
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class JwtSupport(
    @Value("\${jwt.key}")
    private val key: ByteArray
) {

    private val jwtKey = Keys.hmacShaKeyFor(this.key)
    private val parser = Jwts.parserBuilder().setSigningKey(jwtKey).build()

    fun generate(username: String): BearerToken {
        val builder = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date.from(Instant.now()))
            .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
            .signWith(jwtKey)
        return BearerToken(builder.compact())
    }

    fun getUsername(token: BearerToken): String {
        return parser.parseClaimsJwt(token.value).body.subject
    }

    fun isValid(token: BearerToken, authUser: AuthUser?): Boolean {
        val claims = parser.parseClaimsJwt(token.value).body
        val unexpired = claims.expiration.after(Date.from(Instant.now()))
        return unexpired && claims.subject === authUser?.username
    }
}
