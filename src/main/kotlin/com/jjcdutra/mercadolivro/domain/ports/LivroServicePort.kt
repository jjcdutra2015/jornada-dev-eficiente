package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.LivroRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.ListaDeLivroResponse
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.LivroDetalheResponse
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.LivroResponse

interface LivroServicePort {

    fun criaLivro(request: LivroRequest): LivroResponse
    fun listarLivros(): List<ListaDeLivroResponse>
    fun findById(id: Int): LivroDetalheResponse
}