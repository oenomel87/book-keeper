package io.oenomel.keeperserver.domain.entity

import io.oenomel.keeperserver.contant.LoanStatus
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "LOAN")
class Loan (

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    var fromDate: LocalDate,

    var toDate: LocalDate,

    @Enumerated(value = EnumType.STRING)
    var status: LoanStatus,

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    var person: Person,

    @ManyToOne
    @JoinColumn(name = "INVENTORY_ID")
    var inventory: Inventory
)
