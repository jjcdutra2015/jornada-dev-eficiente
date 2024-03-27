package com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions

class RegistroDuplicadoException(override val message: String, val errorCode: String) : Exception()