package com.jjcdutra.mercadolivro.aplication.adpaters.controller.response

import com.jjcdutra.mercadolivro.domain.Autor
import com.jjcdutra.mercadolivro.domain.Categoria
import java.math.BigDecimal

data class LivroDetalheResponse(
    val titulo: String,
    val resumo: String,
    val sumario: String,
    val preco: BigDecimal,
    val numeroDePaginas: Int,
    val isbn: String,
    val dataPublicacao: String,
    val categoria: Categoria,
    val autor: Autor
)