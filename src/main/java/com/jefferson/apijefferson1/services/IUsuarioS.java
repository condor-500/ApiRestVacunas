package com.jefferson.apijefferson1.services;

import java.util.List;

import com.jefferson.apijefferson1.entity.UsuarioE;

public interface IUsuarioS  {
   
   
    List<UsuarioE> findAll();
	
    UsuarioE findById(Long id);
	
	UsuarioE save(UsuarioE usuario);
	
	void delete(Long id);

    
    
}
