package com.jjcdutra.mercadolivro.adpaters.input.controller.request

import com.jjcdutra.mercadolivro.adpaters.input.controller.validation.UniqueValue
import com.jjcdutra.mercadolivro.domain.Categoria
import jakarta.validation.constraints.NotBlank

data class CategoriaRequest(

    @field:NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Categoria::class)
    val nome: String
) {

    fun toModel(): Categoria {
        return Categoria(nome = this.nome)
    }
}