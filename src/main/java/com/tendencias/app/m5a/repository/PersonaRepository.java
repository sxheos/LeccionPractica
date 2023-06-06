/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.m5a.repository;

import com.tendencias.app.m5a.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    @Query(value = "Select * from persona u where u.nombre_persona = :nombre_persona", nativeQuery = true)
    public Persona buscar(String nombre);
}
