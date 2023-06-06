/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.m5a.service;

import com.tendencias.app.m5a.model.Proveedores;
import com.tendencias.app.m5a.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedores, Integer> implements GenericService<Proveedores, Integer> {

    @Autowired
    ProveedorRepository proveedorRepository;


    @Override
    public CrudRepository<Proveedores, Integer> getDao() {
        return proveedorRepository;
    }



}
