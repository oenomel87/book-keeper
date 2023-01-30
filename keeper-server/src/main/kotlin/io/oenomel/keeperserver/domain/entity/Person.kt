package io.oenomel.keeperserver.domain.entity

import io.oenomel.keeperserver.contant.Constants
import jakarta.persistence.*

@Entity
@Table(name = "PERSON")
class Person (

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        var id: Long,

        var account: String,

        var name: String,

        @Enumerated(value = EnumType.STRING)
        var useYn: Constants.YN,

        @OneToMany(mappedBy = "person")
        var loadHistories : List<Loan>?
)
