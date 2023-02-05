package io.oenomel.stream.domain.repository

import io.oenomel.stream.domain.entity.Book
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface BookRepository : R2dbcRepository<Book, Long>
