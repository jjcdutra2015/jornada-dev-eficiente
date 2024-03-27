package com.jjcdutra.mercadolivro.infrastructure.orm

import com.jjcdutra.mercadolivro.domain.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface SpringLivroRepository : JpaRepository<Livro, Int>