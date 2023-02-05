package io.oenomel.stream.config.security

import io.oenomel.stream.config.security.jwt.BearerToken
import io.oenomel.stream.config.security.jwt.JwtSupport
import io.oenomel.stream.exception.BookKeeperAuthenticationException
import io.oenomel.stream.exception.InvalidBearerTokenExeption
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.reactor.mono
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class AuthenticationManager(
    private val jwtSupport: JwtSupport,
    private val authenticationProvider: AuthenticationProvider
) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication?): Mono<Authentication> {
        return Mono.justOrEmpty(authentication)
            .filter { auth -> auth is BearerToken }
            .cast(BearerToken::class.java)
            .flatMap { jwt -> mono { validate(jwt) } }
            .onErrorMap { err -> InvalidBearerTokenExeption(err.message) }
    }

    private suspend fun validate(token: BearerToken): Authentication {
        val username = this.jwtSupport.getUsername(token)
        val member = this.authenticationProvider.findByUsername(username)
            .awaitSingleOrNull()

        if(member == null || !this.jwtSupport.isValid(token, member)) {
            throw BookKeeperAuthenticationException("찾을 수 없는 회원입니다.")
        }

        val authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(member.grants.joinToString(","))
        return UsernamePasswordAuthenticationToken(member.username, member.password, authorities)
    }
}