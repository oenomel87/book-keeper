package io.oenomel.stream.domain.repository

import io.oenomel.stream.domain.entity.Inventory
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface InventoryRepository : R2dbcRepository<Inventory, Long>
