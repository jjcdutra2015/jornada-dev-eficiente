package com.jjcdutra.mercadolivro.infrastructure.adapters.repository

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.LivroRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.LivroResponse
import com.jjcdutra.mercadolivro.domain.ports.AutorServicePort
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import com.jjcdutra.mercadolivro.domain.ports.LivroServicePort
import org.springframework.stereotype.Service

@Service
class LivroServicePortImpl(
    private val springLivroRepository: SpringLivroRepository,
    private val categoriaServicePort: CategoriaServicePort,
    private val autorServicePort: AutorServicePort
) : LivroServicePort {

    override fun criaLivro(request: LivroRequest): LivroResponse {
        val livro = springLivroRepository.save(request.toModel(categoriaServicePort, autorServicePort))

        return livro.toResponse()
    }
}