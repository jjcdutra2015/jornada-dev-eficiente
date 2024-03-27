package com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions

class NaoEncontradoException(override val message: String, val errorCode: String) : Exception()