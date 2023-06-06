/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.m5a.repository;

import com.tendencias.app.m5a.model.Producto;
import com.tendencias.app.m5a.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VentaRepository extends JpaRepository<Venta, Integer>{
    @Query(value = "Select * from venta u where u.nombre_producto = :nombre_producto", nativeQuery = true)
    public Producto buscar(String nombre);
}
