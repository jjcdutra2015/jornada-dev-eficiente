package com.jjcdutra.mercadolivro.aplication.adpaters.controller

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.LivroRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.ListaDeLivroResponse
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.LivroDetalheResponse
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.LivroResponse
import com.jjcdutra.mercadolivro.domain.ports.LivroServicePort
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/livros")
class LivroController(
    private val livroServicePort: LivroServicePort
) {

    @PostMapping
    fun cria(@RequestBody @Valid request: LivroRequest): LivroResponse {
        return livroServicePort.criaLivro(request)
    }

    @GetMapping
    fun findAll(): List<ListaDeLivroResponse> {
        return livroServicePort.listarLivros()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): LivroDetalheResponse {
        return livroServicePort.findById(id)
    }
}