package com.jjcdutra.mercadolivro.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.LivroResponse
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.validation.UniqueValue
import jakarta.persistence.*
import jakarta.validation.constraints.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "livro")
data class Livro(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank
    val titulo: String,

    @field:NotBlank
    @field:Size(max = 500)
    val resumo: String,

    val sumario: String,

    @field:NotNull
    @field:Min(20)
    val preco: BigDecimal,

    @field:NotNull
    @field:Min(100)
    val numeroDePaginas: Int,

    @field:NotBlank
    val isbn: String,

    @field:Future
    @field:JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    val dataPublicacao: LocalDate,

    @field:NotNull
    @field:ManyToOne
    val categoria: Categoria,

    @field:NotNull

    @field:ManyToOne
    val autor: Autor
) {

    fun toResponse(): LivroResponse =
        LivroResponse(
            id = this.id,
            titulo = this.titulo,
            resumo = this.resumo,
            sumario = this.sumario,
            preco = this.preco,
            numeroDePaginas = this.numeroDePaginas,
            isbn = this.isbn,
            dataPublicacao = this.dataPublicacao,
            categoria = this.categoria,
            autor = this.autor
        )
}
