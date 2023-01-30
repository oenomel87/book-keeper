package io.oenomel.keeperserver.domain.repository

import io.oenomel.keeperserver.domain.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface BookRepository : JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book>
