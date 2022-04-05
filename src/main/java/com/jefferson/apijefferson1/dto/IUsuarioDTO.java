package com.jefferson.apijefferson1.dto;

import com.jefferson.apijefferson1.entity.UsuarioE;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDTO extends CrudRepository<UsuarioE, Long> {

   // public UsuarioE findByUsuarioNombre(String nombre );

    @Query("select u from UsuarioE u where u.nombre =?1")
    public UsuarioE findByUsuarioNombre1(String nombre );
    
}
