package com.tendencias.app.m5a.controller;

import com.tendencias.app.m5a.model.Producto;
import com.tendencias.app.m5a.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl service;

    @Operation(summary  = "Se obtiene la lista de productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de los productos")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProductos(@RequestBody Producto p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto p) {
        Producto produc = service.findById(id);
        if (produc != null) {
            try {
                produc.setNombre_producto(p.getNombre_producto());
                produc.setDescripcion(p.getDescripcion());
                produc.setCategoria(p.getCategoria());
                produc.setPrecio(p.getPrecio());
                produc.setImg_producto(p.getImg_producto());
                produc.setVenta(p.getVenta());
                return new ResponseEntity<>(service.save(produc), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}