package com.jjcdutra.mercadolivro.aplication.adpaters.controller

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.request.CategoriaRequest
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.CategoriaResponse
import com.jjcdutra.mercadolivro.domain.ports.CategoriaServicePort
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categorias")
class CategoriaController(
    private val categoriaServicePort: CategoriaServicePort
) {

    @PostMapping
    fun criaCategoria(@RequestBody @Valid categoriaRequest: CategoriaRequest): CategoriaResponse {
        return categoriaServicePort.criaCategoria(categoriaRequest)
    }
}