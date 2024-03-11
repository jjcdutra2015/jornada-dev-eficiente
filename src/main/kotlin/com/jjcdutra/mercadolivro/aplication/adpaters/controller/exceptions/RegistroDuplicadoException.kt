package com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions

class RegistroDuplicadoException(override val message: String, val errorCode: String) : Exception()