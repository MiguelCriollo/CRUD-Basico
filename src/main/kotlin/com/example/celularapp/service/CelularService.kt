package com.example.celularapp.service

import com.example.celularapp.model.Celular
import com.example.celularapp.model.Persona
import com.example.celularapp.repository.CelularRepository
import com.example.celularapp.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CelularService {
    @Autowired
    lateinit var celularRepository: CelularRepository
    @Autowired
    lateinit var personaRepository: PersonaRepository
    fun list ():List<Celular>{
        return celularRepository.findAll()
    }
    fun save(modelo: Celular): Celular{
        println(modelo)
        try{
            modelo.color?.takeIf { it.trim().isNotEmpty() }?:throw Exception("Color no debe ser Vacio")
            modelo.modelo?.takeIf { it.trim().isNotEmpty() }?:throw Exception("Modelo no debe ser Vacio")
            personaRepository.findById(modelo.idPersona)
                ?:throw Exception("Id del cliente no existe")
            return celularRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: Celular): Celular{
        try {
            celularRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return celularRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(modelo:Celular): Celular{
        try{
            val response = celularRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")
            response.apply {
                color=modelo.color
            }
            return celularRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Celular?{
        return celularRepository.findById(id)
    }

    fun delete (id: Long?):String?{
        try{
            val response = celularRepository.findById(id)
                ?: throw Exception("ID no existe")
            celularRepository.deleteById(id!!)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}