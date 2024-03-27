package com.jjcdutra.mercadolivro.adpaters.input.controller

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.PaisRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.PaisResponse
import com.jjcdutra.mercadolivro.domain.ports.PaisServicePort
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/paises")
class PaisController(
    private val paisServicePort: PaisServicePort
) {

    @PostMapping
    fun criar(@RequestBody @Valid request: PaisRequest): PaisResponse {
        return paisServicePort.criar(request)
    }
}