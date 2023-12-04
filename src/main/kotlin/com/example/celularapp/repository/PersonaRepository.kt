package com.example.celularapp.repository

import com.example.celularapp.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonaRepository : JpaRepository<Persona, Long?> {

    fun findById (id: Long?): Persona?

}