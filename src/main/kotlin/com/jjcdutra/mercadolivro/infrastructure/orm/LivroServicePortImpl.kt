package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.NaoEncontradoException
import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.adpaters.input.controller.request.LivroRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.ListaDeLivroResponse
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.LivroDetalheResponse
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.LivroResponse
import com.jjcdutra.mercadolivro.domain.ports.AutorServicePort
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import com.jjcdutra.mercadolivro.domain.ports.LivroServicePort
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter
import kotlin.jvm.optionals.getOrElse

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

    override fun listarLivros(): List<ListaDeLivroResponse> {
        val livros = springLivroRepository.findAll()

        return livros.map { livro ->
            ListaDeLivroResponse(
                id = livro.id,
                titulo = livro.titulo
            )
        }
    }

    override fun findById(id: Int): LivroDetalheResponse {
        val livro = springLivroRepository.findById(id).getOrElse {
            throw NaoEncontradoException("Livro nao encontrado", Errors.MLOO3.code)
        }
        return LivroDetalheResponse(
            titulo = livro.titulo,
            resumo = livro.resumo,
            sumario = livro.sumario,
            preco = livro.preco,
            numeroDePaginas = livro.numeroDePaginas,
            isbn = livro.isbn,
            dataPublicacao = livro.dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyyy")),
            categoria = livro.categoria,
            autor = livro.autor
        )
    }
}