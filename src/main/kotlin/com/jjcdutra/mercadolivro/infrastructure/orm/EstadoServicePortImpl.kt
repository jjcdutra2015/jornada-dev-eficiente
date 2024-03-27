package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.EstadoRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.EstadoResponse
import com.jjcdutra.mercadolivro.domain.ports.EstadoServicePort
import com.jjcdutra.mercadolivro.domain.ports.PaisServicePort
import org.springframework.stereotype.Service

@Service
class EstadoServicePortImpl(
    private val repository: SpringEstadoRepository,
    private val paisServicePort: PaisServicePort
) : EstadoServicePort {

    override fun criar(request: EstadoRequest): EstadoResponse {
        return repository.save(request.toModel(paisServicePort)).toResponse()
    }
}