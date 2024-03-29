package com.luciano.cadastropessoa.cadastrarpessoa.model
import jakarta.persistence.*

@Entity
@Table(name = "tb_address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAddress: Long,
    val cep: String,
    val road: String,
    val city: String,
    val numberResidence: String,
    val complement: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    var state: StateUF
)
