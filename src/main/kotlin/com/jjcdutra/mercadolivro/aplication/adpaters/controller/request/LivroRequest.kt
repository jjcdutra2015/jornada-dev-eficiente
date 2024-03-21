package com.jjcdutra.mercadolivro.aplication.adpaters.controller.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonFormat.Shape
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.validation.UniqueValue
import com.jjcdutra.mercadolivro.domain.Livro
import com.jjcdutra.mercadolivro.domain.ports.AutorServicePort
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import jakarta.validation.constraints.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class LivroRequest(

    @field:NotBlank
    @field:UniqueValue(fieldName = "titulo", domainClass = Livro::class)
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
    @field:JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    val dataPublicacao: LocalDate,

    @field:NotNull
    val idCategoria: Int,

    @field:NotNull
    val idAutor: Int
) {

    fun toModel(categoriaServicePort: CategoriaServicePort, autorServicePort: AutorServicePort): Livro {
        val categoria = categoriaServicePort.findById(idCategoria)
        val autor = autorServicePort.findById(idAutor)
        return Livro(
            titulo = this.titulo,
            resumo = this.resumo,
            sumario = this.sumario,
            preco = this.preco,
            numeroDePaginas = this.numeroDePaginas,
            isbn = this.isbn,
            dataPublicacao = this.dataPublicacao,
            categoria = categoria,
            autor = autor
        )
    }
}
