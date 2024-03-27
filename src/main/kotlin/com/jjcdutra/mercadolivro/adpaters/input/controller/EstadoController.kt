package com.jjcdutra.mercadolivro.adpaters.input.controller

import com.jjcdutra.mercadolivro.adpaters.input.controller.request.EstadoRequest
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.EstadoResponse
import com.jjcdutra.mercadolivro.domain.ports.EstadoServicePort
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estados")
class EstadoController(
    private val estadoServicePort: EstadoServicePort
) {

    @PostMapping
    fun criar(@RequestBody @Valid request: EstadoRequest): EstadoResponse {
        return estadoServicePort.criar(request)
    }
}