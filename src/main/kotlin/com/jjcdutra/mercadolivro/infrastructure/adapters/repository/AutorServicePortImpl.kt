package com.jjcdutra.mercadolivro.infrastructure.adapters.repository

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.EmailDuplicadoException
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.AutorRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.domain.ports.AutorServicePort
import org.springframework.stereotype.Service

@Service
class AutorServicePortImpl(
    private val springAutorRepository: SpringAutorRepository
) : AutorServicePort {

    override fun criaAutor(autorRequest: AutorRequest): AutorResponse {
        val autor = autorRequest.toDomain()

        val emailDuplicado = springAutorRepository.existsByEmail(autor.email)

        if (emailDuplicado) throw EmailDuplicadoException("E-mail já cadastrado: ${autor.email}", Errors.MLOO2.code)

        return springAutorRepository.save(autor).toResponse()
    }

    override fun emailAvailable(email: String): Boolean {
        return springAutorRepository.existsByEmail(email)
    }
}