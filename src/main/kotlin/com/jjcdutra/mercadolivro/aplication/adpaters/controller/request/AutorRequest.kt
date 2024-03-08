package com.jjcdutra.mercadolivro.aplication.adpaters.controller.request

import com.jjcdutra.mercadolivro.domain.Autor
import jakarta.persistence.Column
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AutorRequest(

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    @field:Column(unique = true)
    val email: String,

    @field:NotBlank
    @field:Size(max = 400)
    val descricao: String
) {

    fun toDomain(): Autor {
        return Autor(
            nome = this.nome,
            email = this.email,
            descricao = this.descricao
        )
    }
}