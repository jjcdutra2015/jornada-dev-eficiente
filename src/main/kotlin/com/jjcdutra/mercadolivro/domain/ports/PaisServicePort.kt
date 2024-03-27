package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.PaisRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.PaisResponse
import com.jjcdutra.mercadolivro.domain.Pais

interface PaisServicePort {

    fun criar(request: PaisRequest): PaisResponse
    fun findById(id: Int): Pais
}