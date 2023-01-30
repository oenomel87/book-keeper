package io.oenomel.keeperserver.domain.dto

import io.oenomel.keeperserver.contant.InventoryStatus

data class InventoryInput(
    var id: String,
    var status: InventoryStatus,
    var bookId: String
)
