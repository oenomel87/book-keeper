package io.oenomel.stream.domain.model

import io.oenomel.stream.domain.entity.Book
import org.springframework.util.CollectionUtils

class BookModel(

    val id: String,

    val title: String,

    val isbn: String,

    val inventories: List<InventoryModel>? = ArrayList()
) {

    companion object Converter {
        fun convert(entity: Book): BookModel {
            val inventories = if (CollectionUtils.isEmpty(entity.inventories)) ArrayList()
                else entity.inventories?.map { InventoryModel.convert(it) }
            return BookModel(
                id = entity.id.toString(),
                title = entity.title,
                isbn = entity.isbn,
                inventories = inventories
            )
        }
    }
}
