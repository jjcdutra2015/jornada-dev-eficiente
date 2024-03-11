package com.jjcdutra.mercadolivro.domain

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.validation.EmailAvailable
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Entity
@Table(name = "autor")
data class Autor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    @field:EmailAvailable
    val email: String,

    @field:NotBlank
    @field:Size(max = 400)
    val descricao: String,

    @field:NotNull
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toResponse(): AutorResponse {
        return AutorResponse(
            id,
            nome,
            email,
            descricao,
            createdAt
        )
    }
}
