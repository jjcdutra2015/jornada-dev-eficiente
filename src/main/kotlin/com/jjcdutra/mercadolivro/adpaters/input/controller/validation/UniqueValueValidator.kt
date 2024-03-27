package com.jjcdutra.mercadolivro.adpaters.input.controller.validation

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.util.Assert
import kotlin.reflect.KClass

class UniqueValueValidator : ConstraintValidator<UniqueValue, Any> {
    private var domainAttribute: String? = null
    private var klass: KClass<*>? = null

    @PersistenceContext
    private val manager: EntityManager? = null
    override fun initialize(params: UniqueValue) {
        domainAttribute = params.fieldName
        klass = params.domainClass
    }

    override fun isValid(value: Any, context: ConstraintValidatorContext): Boolean {
        val query =
            manager!!.createQuery("select 1 from " + klass!!.simpleName + " where " + domainAttribute + "=:value")
        query.setParameter("value", value)
        val list = query.resultList
        Assert.isTrue(
            list.size <= 1,
            "Foi encontrado mais de um $klass com o atributo $domainAttribute = $value"
        )
        return list.isEmpty()
    }
}