package com.jjcdutra.mercadolivro.infrastructure.adapters.repository

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.RegistroDuplicadoException
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.CategoriaRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.CategoriaResponse
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import org.springframework.stereotype.Service

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
}