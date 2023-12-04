package com.example.celularapp.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "persona")
class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="nombre no puede ser vacio")
    var nombre: String? = null
    var edad: Int?= 0
    var estudiante: Boolean? =null

}