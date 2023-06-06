package com.tendencias.app.m5a.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Proveedores {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id_prov")
    private int id_prov;
    @Column (name = "nombre_proveedor")
    private String nombre_proveedor;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

}
