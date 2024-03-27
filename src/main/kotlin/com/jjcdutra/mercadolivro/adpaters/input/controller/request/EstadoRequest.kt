package com.jjcdutra.mercadolivro.adpaters.input.controller.request

import com.jjcdutra.mercadolivro.adpaters.input.controller.validation.UniqueValue
import com.jjcdutra.mercadolivro.domain.Estado
import com.jjcdutra.mercadolivro.domain.ports.PaisServicePort
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class EstadoRequest(

    @field:NotBlank
    @field:UniqueValue(fieldName = "nome", domainClass = Estado::class)
    val nome: String,

    @field:NotNull
    val idPais: Int
) {

    fun toModel(paisServicePort: PaisServicePort): Estado {
        val pais = paisServicePort.findById(idPais)
        return Estado(
            nome = this.nome,
            pais = pais
        )
    }
}
