package com.tendencias.app.m5a.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre_producto")
    private String nombre_producto;

    @NotBlank(message = " La descripcion no puede estar en blanco")
    private String descripcion;

    @NotBlank(message = " La descripcion no puede estar en blanco")
    private String categoria;

    @NotBlank(message = " La descripcion no puede estar en blanco")
    private double precio;

    private String img_producto;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<Proveedores> listaproveedores;

    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    private Venta venta;


}
