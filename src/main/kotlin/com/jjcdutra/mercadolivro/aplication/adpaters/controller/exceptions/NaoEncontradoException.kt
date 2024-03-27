package com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions

class NaoEncontradoException(override val message: String, val errorCode: String) : Exception()