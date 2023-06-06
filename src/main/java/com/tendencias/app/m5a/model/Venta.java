package com.tendencias.app.m5a.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private int id_venta;
    private int cantidad;
    private double precio;
    private Date fechaventa;
     //relaciones con productos
     @JsonIgnore
     @OneToMany(mappedBy = "venta")
     private List<Producto> listaproductos;
}
