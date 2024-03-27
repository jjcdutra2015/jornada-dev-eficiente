package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.NaoEncontradoException
import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.adpaters.input.controller.request.PaisRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.PaisResponse
import com.jjcdutra.mercadolivro.domain.Pais
import com.jjcdutra.mercadolivro.domain.ports.PaisServicePort
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class PaisServicePortImpl(
    private val paisRepository: SpringPaisRepository
) : PaisServicePort {

    override fun criar(request: PaisRequest): PaisResponse {
        return paisRepository.save(request.toModel()).toResponse()
    }

    override fun findById(id: Int): Pais {
        return paisRepository.findById(id).getOrElse {
            throw NaoEncontradoException("Pais não encontrado", Errors.MLOO3.code)
        }
    }
}