package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.RegistroDuplicadoException
import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.adpaters.input.controller.request.CategoriaRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.CategoriaResponse
import com.jjcdutra.mercadolivro.domain.Categoria
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class CategoriaServicePortImpl(
    private val springCategoriaRepository: SpringCategoriaRepository
) : CategoriaServicePort {

    override fun criaCategoria(categoriaRequest: CategoriaRequest): CategoriaResponse {
        val categoria = categoriaRequest.toModel()

        val categoriaDuplicada = springCategoriaRepository.existsByNome(categoria.nome)

        if (categoriaDuplicada) throw RegistroDuplicadoException(
            "Nome já cadastrado: ${categoria.nome}",
            Errors.MLOO2.code
        )

        springCategoriaRepository.save(categoria)

        return categoria.toResponse()
    }

    override fun nomeDuplicado(nome: String): Boolean {
        return springCategoriaRepository.existsByNome(nome)
    }

    override fun findById(id: Int): Categoria {
        return springCategoriaRepository.findById(id).getOrElse { throw NotFoundException() }
    }
}