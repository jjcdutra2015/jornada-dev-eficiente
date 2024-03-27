package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.domain.Autor
import org.springframework.data.jpa.repository.JpaRepository

interface SpringAutorRepository : JpaRepository<Autor, Int> {

    fun existsByEmail(value: String): Boolean
}