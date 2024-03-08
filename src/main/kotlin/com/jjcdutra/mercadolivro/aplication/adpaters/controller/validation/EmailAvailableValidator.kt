package com.jjcdutra.mercadolivro.aplication.adpaters.controller.validation

import com.jjcdutra.mercadolivro.infrastructure.adapters.repository.AutorServicePortImpl
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvailableValidator(val autorServicePortImpl: AutorServicePortImpl) :
    ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) return false

        return autorServicePortImpl.emailAvailable(value)
    }
}