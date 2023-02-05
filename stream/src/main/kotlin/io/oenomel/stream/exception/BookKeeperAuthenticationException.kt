package io.oenomel.stream.exception

import org.springframework.security.core.AuthenticationException

class BookKeeperAuthenticationException (message: String?): AuthenticationException(message)
