package io.oenomel.keeperserver.domain.repository

import io.oenomel.keeperserver.domain.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface UserRepository: JpaRepository<Person, Long>
