package com.tendencias.app.m5a.controller;

import com.tendencias.app.m5a.model.Rol;
import com.tendencias.app.m5a.service.RolServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolServiceImpl rolService;

    @Operation(summary  = "Se obtiene la lista de Roles")
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listaRol() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Rol")
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol u) {
        return new ResponseEntity<>(rolService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarUsuario(@PathVariable Integer id, @RequestBody Rol u) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            try {
                rol.setNombre(u.getNombre());
                rol.setDescripcion(u.getDescripcion());
                rol.setEstado(u.getEstado());
                return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> elimiarRol(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
