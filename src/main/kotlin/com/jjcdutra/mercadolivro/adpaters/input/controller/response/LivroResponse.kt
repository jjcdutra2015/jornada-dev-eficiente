package com.jjcdutra.mercadolivro.adpaters.input.controller.response

import com.jjcdutra.mercadolivro.domain.Autor
import com.jjcdutra.mercadolivro.domain.Categoria
import java.math.BigDecimal
import java.time.LocalDate

data class LivroResponse(
    val id: Int? = null,
    val titulo: String,
    val resumo: String,
    val sumario: String,
    val preco: BigDecimal,
    val numeroDePaginas: Int,
    val isbn: String,
    val dataPublicacao: LocalDate,
    val categoria: Categoria,
    val autor: Autor
)