package com.example.celularapp.repository

import com.example.celularapp.model.Celular
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CelularRepository: JpaRepository<Celular, Long?> {
    fun findById (id: Long?): Celular?
}