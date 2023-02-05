package io.oenomel.stream.config.security.jwt

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils

class BearerToken(val value: String)
    : AbstractAuthenticationToken(AuthorityUtils.NO_AUTHORITIES) {

    override fun getCredentials() = value

    override fun getPrincipal() = value
}
