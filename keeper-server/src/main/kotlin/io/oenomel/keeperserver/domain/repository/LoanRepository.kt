package io.oenomel.keeperserver.domain.repository

import io.oenomel.keeperserver.domain.entity.Loan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface LoanRepository: JpaRepository<Loan, Long>
