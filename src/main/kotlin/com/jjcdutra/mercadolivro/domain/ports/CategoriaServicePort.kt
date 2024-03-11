package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.CategoriaRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.CategoriaResponse

interface CategoriaServicePort {

    fun criaCategoria(categoriaRequest: CategoriaRequest): CategoriaResponse
    fun nomeDuplicado(value: String): Boolean
}