/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.m5a.repository;

import com.tendencias.app.m5a.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProveedorRepository extends JpaRepository<Proveedores, Integer>{
    @Query(value = "Select * from proveedores u where u.nombre_proveedor = :nombre_proveedor", nativeQuery = true)
    public Proveedores buscar(String nombre);
}
