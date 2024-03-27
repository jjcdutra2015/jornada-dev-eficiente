package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.AutorRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.domain.Autor

interface AutorServicePort {

    fun criaAutor(autorRequest: AutorRequest): AutorResponse
    fun emailAvailable(email: String) : Boolean
    fun findById(id: Int): Autor
}