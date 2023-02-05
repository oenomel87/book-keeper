package io.oenomel.stream.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "BOOK")
class Book (
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        var id: Long,

        var title: String,

        var isbn: String,

        @OneToMany(mappedBy = "book")
        var inventories: List<Inventory>?
)
