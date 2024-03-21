package com.jjcdutra.mercadolivro.aplication.adpaters.controller

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.LivroRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.LivroResponse
import com.jjcdutra.mercadolivro.domain.ports.LivroServicePort
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController(
    private val livroServicePort: LivroServicePort
) {

    @PostMapping
    fun cria(@RequestBody @Valid request: LivroRequest): LivroResponse {
        return livroServicePort.criaLivro(request)
    }
}