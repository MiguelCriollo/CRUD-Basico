package com.example.celularapp.service

import com.example.celularapp.Repository.PersonaRepository
import com.example.celularapp.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonaService {
    @Autowired
    lateinit var personaRepository: PersonaRepository

    fun list ():List<Persona>{
        return personaRepository.findAll()
    }
    fun save(modelo: Persona): Persona{
        try{
            return personaRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(modelo: Persona): Persona{
        try {
            personaRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return personaRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(modelo:Persona): Persona{
        try{
            val response = personaRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre=modelo.nombre
            }
            return personaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Persona?{
        return personaRepository.findById(id)
    }

    fun delete (id: Long?):String?{
        try{
            val response = personaRepository.findById(id)
                ?: throw Exception("ID no existe")
            personaRepository.deleteById(id!!)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}