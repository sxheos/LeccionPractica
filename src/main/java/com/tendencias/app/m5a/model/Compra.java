package com.tendencias.app.m5a.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id_compra;
}
