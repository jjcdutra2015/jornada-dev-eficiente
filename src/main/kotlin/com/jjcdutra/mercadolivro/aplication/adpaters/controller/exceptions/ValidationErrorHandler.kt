package com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions

import com.jjcdutra.mercadolivro.aplication.adpaters.controller.exceptions.enums.Errors
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.ErrorResponse
import com.jjcdutra.mercadolivro.aplication.adpaters.controller.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationErrorHandler() {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
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
}