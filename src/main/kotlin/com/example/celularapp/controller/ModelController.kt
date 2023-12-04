package com.example.celularapp.controller

import com.example.celularapp.model.Persona
import com.example.celularapp.service.PersonaService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/persona")   //endpoint
class ModelController {
    @Autowired
    lateinit var modeloService: PersonaService
/*
    @GetMapping
    fun list ():List <Persona>{
        return modeloService.list()
    }
    */

    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(modeloService.list(), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody @Valid modelo:Persona):ResponseEntity<Persona>{
        return ResponseEntity(modeloService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo:Persona):ResponseEntity<Persona>{
        return ResponseEntity(modeloService.update(modelo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo:Persona):ResponseEntity<Persona>{
        return ResponseEntity(modeloService.updateName(modelo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        println("Entered Get BY ID")
        return ResponseEntity(modeloService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):String?{
        println("Entered Delete By ID")
        return modeloService.delete(id)
    }
}