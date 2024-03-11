package com.jjcdutra.mercadolivro.aplication.adpaters.controller.response

import java.time.LocalDateTime

data class AutorResponse(
    val id: Int?,
    val nome: String,
    val email: String,
    val descricao: String,
    val createdAt: LocalDateTime
)