package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.domain.Pais
import org.springframework.data.jpa.repository.JpaRepository

interface SpringPaisRepository : JpaRepository<Pais, Int>