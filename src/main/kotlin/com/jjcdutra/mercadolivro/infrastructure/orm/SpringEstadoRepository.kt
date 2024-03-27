package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.domain.Estado
import org.springframework.data.jpa.repository.JpaRepository

interface SpringEstadoRepository : JpaRepository<Estado, Int>