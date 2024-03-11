package com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions

class EmailDuplicadoException(override val message: String, val errorCode: String) : Exception()