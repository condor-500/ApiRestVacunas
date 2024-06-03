package com.jefferson.apijefferson1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import com.jefferson.apijefferson1.entity.VacunaE;
import com.jefferson.apijefferson1.services.IVacunaService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/vacuna")
public class VacunaController {


    @Autowired
    IVacunaService vacunaService;

    @GetMapping("/all")
    public List<VacunaE> getMethodName() {
        return vacunaService.listVacuna();
    }
    
    
}
