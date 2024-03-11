package com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.enums

enum class Errors(val code: String, val message: String) {
    MLOO1("ML-001", "Invalid request"),
    MLOO2("ML-002", "Duplicate record")
}