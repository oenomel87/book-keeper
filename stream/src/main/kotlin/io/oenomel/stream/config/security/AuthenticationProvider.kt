package io.oenomel.stream.config.security

import io.oenomel.stream.domain.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import reactor.core.publisher.Mono

@Service
class AuthenticationProvider(private val memberRepository: MemberRepository) {
    fun findByUsername(username: String?): Mono<AuthUser> {
        if(StringUtils.hasText(username)) {
            return Mono.empty()
        }

        val member = username?.let { this.memberRepository.findByUsername(it) } ?: return Mono.empty()
        val auth = AuthUser(username = member.get().username, name = member.get().name, password = member.get().password, listOf("ROLE_USER"))
        return Mono.just(auth)
    }
}
