package com.jjcdutra.mercadolivro.aplication.adpaters.controller.response

import java.time.LocalDateTime

data class AutorResponse(
    val id: Long,
    val nome: String,
    val email: String,
    val descricao: String,
    val createdAt: LocalDateTime
)