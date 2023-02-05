package io.oenomel.stream.domain.dto

import io.oenomel.stream.domain.contant.InventoryStatus

data class InventoryInput(
    var id: String,
    var status: InventoryStatus,
    var bookId: String
)
