package com.jjcdutra.mercadolivro.aplication.adpaters.controller

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.AutorRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.infrastructure.adapters.repository.AutorServicePortImpl
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autores")
class AutorController(
    private val autorServicePortImpl: AutorServicePortImpl
) {

    @PostMapping
    fun criaAutor(@RequestBody @Valid autorRequest: AutorRequest): AutorResponse {
        return autorServicePortImpl.criaAutor(autorRequest)
    }
}