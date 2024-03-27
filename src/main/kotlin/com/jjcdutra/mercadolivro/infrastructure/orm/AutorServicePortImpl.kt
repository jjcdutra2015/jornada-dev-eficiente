package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.RegistroDuplicadoException
import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.adpaters.input.controller.request.AutorRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.domain.Autor
import com.jjcdutra.mercadolivro.domain.ports.AutorServicePort
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class AutorServicePortImpl(
    private val springAutorRepository: SpringAutorRepository
) : AutorServicePort {

    override fun criaAutor(autorRequest: AutorRequest): AutorResponse {
        val autor = autorRequest.toDomain()

        val emailDuplicado = springAutorRepository.existsByEmail(autor.email)

        if (emailDuplicado) throw RegistroDuplicadoException("E-mail já cadastrado: ${autor.email}", Errors.MLOO2.code)

        return springAutorRepository.save(autor).toResponse()
    }

    override fun emailAvailable(email: String): Boolean {
        return springAutorRepository.existsByEmail(email)
    }

    override fun findById(id: Int): Autor {
        return springAutorRepository.findById(id).getOrElse { throw NotFoundException() }
    }
}