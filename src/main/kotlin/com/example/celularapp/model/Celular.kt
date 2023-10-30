package com.example.celularapp.model

import jakarta.persistence.*

@Entity
@Table(name = "celular")
class Celular {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var modelo: String? = null
    var color: String?= null
    @Column(name="id_persona")
    var idPersona: Long? = null
}