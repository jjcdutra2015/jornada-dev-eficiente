package com.jjcdutra.mercadolivro.domain

import com.jjcdutra.mercadolivro.adpaters.input.controller.response.EstadoResponse
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "estado")
data class Estado(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank
    val nome: String,

    @field:NotNull
    @ManyToOne
    val pais: Pais
) {

    fun toResponse() = EstadoResponse(
        id = this.id,
        nome = this.nome,
        pais = this.pais
    )
}
