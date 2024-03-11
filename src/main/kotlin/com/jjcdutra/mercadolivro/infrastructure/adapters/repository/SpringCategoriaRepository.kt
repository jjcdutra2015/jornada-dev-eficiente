package com.jjcdutra.mercadolivro.infrastructure.adapters.repository

import com.jjcdutra.mercadolivro.domain.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface SpringCategoriaRepository : JpaRepository<Categoria, Int> {

    fun existsByNome(value: String): Boolean
}