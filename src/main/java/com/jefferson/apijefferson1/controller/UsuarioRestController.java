package com.jefferson.apijefferson1.controller;

import java.util.List;

import com.jefferson.apijefferson1.entity.UsuarioE;
import com.jefferson.apijefferson1.services.IUsuarioS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {



    @Autowired
    IUsuarioS usuarioS ;

    @GetMapping("/usuarios")
   public List<UsuarioE> all(){
        return usuarioS.findAll();
   }
    
}
