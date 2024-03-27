package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.CategoriaRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.CategoriaResponse
import com.jjcdutra.mercadolivro.domain.Categoria

interface CategoriaServicePort {

    fun criaCategoria(categoriaRequest: CategoriaRequest): CategoriaResponse
    fun nomeDuplicado(value: String): Boolean
    fun findById(id: Int): Categoria
}