package com.example.celularapp.model

import jakarta.persistence.*

@Entity
@Table(name = "persona")
class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var edad: Int?= 0
    var estudiante: Boolean? =null

}