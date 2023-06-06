package com.tendencias.app.m5a.repository;

import com.tendencias.app.m5a.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepostory extends JpaRepository<Rol, Integer> {
    @Query(value = "Select * from rol u where u.nombre = :nombre", nativeQuery = true)
    public Rol buscar(String nombre);

}
