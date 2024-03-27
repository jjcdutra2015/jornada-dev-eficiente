package com.jjcdutra.mercadolivro.adpaters.input.controller

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.AutorRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.AutorResponse
import com.jjcdutra.mercadolivro.infrastructure.orm.AutorServicePortImpl
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