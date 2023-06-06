/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.m5a.repository;

import com.tendencias.app.m5a.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
        @Query(value = "Select * from usuario u where u.nombre_rol = :nombre_rol", nativeQuery = true)
    public Usuario buscarUsuario(String nombre);
}
