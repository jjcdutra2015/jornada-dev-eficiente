package com.jjcdutra.mercadolivro.adpaters.input.controller.response

import com.jjcdutra.mercadolivro.domain.Pais

data class EstadoResponse(

    val id: Int?,
    val nome: String,
    val pais: Pais
)