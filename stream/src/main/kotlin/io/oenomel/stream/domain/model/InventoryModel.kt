package io.oenomel.stream.domain.model

import io.oenomel.stream.domain.contant.InventoryStatus
import io.oenomel.stream.domain.entity.Inventory

class InventoryModel(

    val id: String,

    val status: InventoryStatus
) {
    companion object Converter {
        fun convert(entity: Inventory): InventoryModel {
            return InventoryModel(
                id = entity.id.toString(),
                status = entity.status
            )
        }
    }
}
