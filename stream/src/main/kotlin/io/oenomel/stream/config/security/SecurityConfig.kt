package io.oenomel.stream.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter

@EnableWebFluxSecurity
@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity,
                            authenticationManager: AuthenticationManager,
                            converter: JwtAuthenticationConverter): SecurityWebFilterChain {
        val filter = AuthenticationWebFilter(authenticationManager)
        filter.setServerAuthenticationConverter(converter)
        return http.authorizeExchange {
                ex -> ex.pathMatchers("/**").permitAll()
            }
            .httpBasic().disable()
            .csrf().disable()
            .formLogin().disable()
            .logout().disable()
            .addFilterAfter(filter, SecurityWebFiltersOrder.AUTHENTICATION)
            .authorizeExchange { ex -> ex.anyExchange().authenticated() }
            .build()
    }
}
