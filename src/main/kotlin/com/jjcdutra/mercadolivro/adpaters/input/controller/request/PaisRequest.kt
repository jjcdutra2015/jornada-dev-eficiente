package com.jjcdutra.mercadolivro.adpaters.input.controller.request

import com.jjcdutra.mercadolivro.adpaters.input.controller.validation.UniqueValue
import com.jjcdutra.mercadolivro.domain.Pais
import jakarta.validation.constraints.NotBlank

data class PaisRequest(

    @field:NotBlank
    @field:UniqueValue(fieldName = "nome", domainClass = Pais::class)
    val nome: String
) {

    fun toModel() = Pais(
        nome = this.nome
    )
}
