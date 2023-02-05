package io.oenomel.stream.domain.repository

import io.oenomel.stream.domain.entity.Loan
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface LoanRepository: R2dbcRepository<Loan, Long>
