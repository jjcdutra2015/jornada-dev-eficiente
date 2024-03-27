package com.jjcdutra.mercadolivro.domain

import com.jjcdutra.mercadolivro.adpaters.input.controller.response.CategoriaResponse
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "categoria")
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @field:NotBlank
    val nome: String,
) {
    fun toResponse(): CategoriaResponse {
        return CategoriaResponse(id = this.id, nome = this.nome)
    }
}
