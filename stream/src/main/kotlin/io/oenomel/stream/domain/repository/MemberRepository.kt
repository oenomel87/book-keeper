package io.oenomel.stream.domain.repository

import io.oenomel.stream.domain.entity.Member
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.Optional

@GraphQlRepository
interface MemberRepository: R2dbcRepository<Member, Long> {
    fun findByUsername(username: String) : Optional<Member>
}
