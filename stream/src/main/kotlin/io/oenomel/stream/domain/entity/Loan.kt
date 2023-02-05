package io.oenomel.stream.domain.entity

import io.oenomel.stream.domain.contant.LoanStatus
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
    @JoinColumn(name = "MEMBER_ID")
    var member: Member,

    @ManyToOne
    @JoinColumn(name = "INVENTORY_ID")
    var inventory: Inventory
)
