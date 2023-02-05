package io.oenomel.stream.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class Member (

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        var id: Long,

        var username: String,

        var name: String,

        var password: String,

        var enabled: Boolean,

        @OneToMany(mappedBy = "member")
        var loadHistories : List<Loan>?
)
