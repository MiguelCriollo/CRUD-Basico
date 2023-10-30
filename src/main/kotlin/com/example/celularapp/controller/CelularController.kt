package com.example.celularapp.controller

import com.example.celularapp.model.Celular
import com.example.celularapp.model.Persona
import com.example.celularapp.service.CelularService
import com.example.celularapp.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/celular")   //endpoint
class CelularController {
    @Autowired
    lateinit var celularService: CelularService

    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(celularService.list(), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody modelo: Celular):ResponseEntity<Celular>{
        return ResponseEntity(celularService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo:Celular):ResponseEntity<Celular>{
        return ResponseEntity(celularService.update(modelo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo:Celular):ResponseEntity<Celular>{
        return ResponseEntity(celularService.updateName(modelo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        println("Entered Get BY ID")
        return ResponseEntity(celularService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):String?{
        println("Entered Delete By ID")
        return celularService.delete(id)
    }
}