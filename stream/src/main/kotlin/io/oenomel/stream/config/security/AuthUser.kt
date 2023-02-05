package io.oenomel.stream.config.security

class AuthUser(
    val username: String,
    val name: String,
    val password: String,
    val grants: List<String>
)
