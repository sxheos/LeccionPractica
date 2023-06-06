package com.tendencias.app.m5a.controller;

import com.tendencias.app.m5a.model.Persona;
import com.tendencias.app.m5a.service.PersonaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personService;

    @Operation(summary  = "Se obtiene la lista de personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaPersona() {
        return new ResponseEntity<>(personService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Persona")
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona p) {
        return new ResponseEntity<>(personService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona p) {
        Persona person = personService.findById(id);
        if (person != null) {
            try {
                person.setNombre(p.getNombre());
                person.setApellido(p.getApellido());
                person.setCorreo(p.getCorreo());
                person.setCedula(p.getCedula());
                person.setCelular(p.getCelular());
                person.setDireccion(p.getDireccion());

                return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> elimiarPersona(@PathVariable Integer id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
