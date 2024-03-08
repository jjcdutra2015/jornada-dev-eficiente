package com.jjcdutra.mercadolivro.infrastructure.adapters.repository

import com.jjcdutra.mercadolivro.domain.Autor
import org.springframework.data.jpa.repository.JpaRepository

interface SpringAutorRepository : JpaRepository<Autor, Long> {

    fun existsByEmail(value: String): Boolean
}