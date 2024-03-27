package com.jjcdutra.mercadolivro.domain.ports

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.EstadoRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.EstadoResponse

interface EstadoServicePort {

    fun criar(request: EstadoRequest): EstadoResponse
}