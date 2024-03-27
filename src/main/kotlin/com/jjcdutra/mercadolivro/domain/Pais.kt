package com.jjcdutra.mercadolivro.domain

import com.jjcdutra.mercadolivro.adpaters.input.controller.response.PaisResponse
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "pais")
data class Pais(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank
    val nome: String
) {

    fun toResponse() = PaisResponse(
        id = this.id,
        nome = this.nome
    )
}
