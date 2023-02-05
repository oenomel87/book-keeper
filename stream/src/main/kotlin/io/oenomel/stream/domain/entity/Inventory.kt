package io.oenomel.stream.domain.entity

import io.oenomel.stream.domain.contant.InventoryStatus
import jakarta.persistence.*

@Entity
@Table(name = "INVENTORY")
class Inventory(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        var id: Long,

        @Enumerated(value = EnumType.STRING)
        var status: InventoryStatus,

        @ManyToOne
        @JoinColumn(name = "BOOK_ID")
        var book: Book
)
