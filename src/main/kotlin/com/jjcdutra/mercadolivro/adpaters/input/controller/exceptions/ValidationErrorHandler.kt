package com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions

import com.jjcdutra.mercadolivro.adpaters.input.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.ErrorResponse
import com.jjcdutra.mercadolivro.adpaters.input.controller.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationErrorHandler() {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.MLOO1.message,
            Errors.MLOO1.code,
            exception.bindingResult.fieldErrors.map {
                FieldErrorResponse(
                    it.field,
                    it.defaultMessage ?: "invalid"
                )
            }
        )
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(RegistroDuplicadoException::class)
    fun handleRegistroDuplicadoException(exception: RegistroDuplicadoException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.CONFLICT.value(),
            exception.message,
            exception.errorCode,
            null
        )
        return ResponseEntity(error, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(NaoEncontradoException::class)
    fun handleNaoEncontradoException(exception: NaoEncontradoException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.message,
            exception.errorCode,
            null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}