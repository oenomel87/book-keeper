package io.oenomel.keeperserver.domain.model

import io.oenomel.keeperserver.contant.InventoryStatus
import io.oenomel.keeperserver.domain.entity.Inventory

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
