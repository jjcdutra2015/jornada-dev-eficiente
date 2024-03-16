package com.jjcdutra.mercadolivro.aplication.adpaters.controller.request

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.validation.UniqueValue
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