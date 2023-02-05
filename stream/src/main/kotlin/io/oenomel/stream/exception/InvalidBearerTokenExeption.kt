package io.oenomel.stream.exception

import javax.naming.AuthenticationException

class InvalidBearerTokenExeption(message: String?) : AuthenticationException(message)
