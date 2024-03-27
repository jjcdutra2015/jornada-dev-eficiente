package com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums

enum class Errors(val code: String, val message: String) {
    MLOO1("ML-001", "Invalid request"),
    MLOO2("ML-002", "Duplicate record"),
    MLOO3("ML-003", "Not found")
}