package com.tendencias.app.m5a.controller;

import com.tendencias.app.m5a.model.Producto;
import com.tendencias.app.m5a.model.Proveedores;
import com.tendencias.app.m5a.service.ProductoServiceImpl;
import com.tendencias.app.m5a.service.ProveedorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorServiceImpl service;

    @Operation(summary  = "Se obtiene la lista de provedores")
    @GetMapping("/listar")
    public ResponseEntity<List<Proveedores>> listaProveedores() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de los productos")
    @PostMapping("/crear")
    public ResponseEntity<Proveedores> crearProveedores(@RequestBody Proveedores p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedores> actualizarProveedores(@PathVariable Integer id, @RequestBody Proveedores p) {
        Proveedores pv = service.findById(id);
        if (pv != null) {
            try {
                pv.setNombre_proveedor(p.getNombre_proveedor());
                pv.setProducto(p.getProducto());

                return new ResponseEntity<>(service.save(pv), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Proveedores> elimiarProveedores(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}