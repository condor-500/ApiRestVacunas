package com.jefferson.apijefferson1.services;
import java.util.List;

import com.jefferson.apijefferson1.entity.UsuarioE;
import com.jefferson.apijefferson1.entity.VacunaE;

public interface IVacunaService {

    List<VacunaE> listVacuna();
    VacunaE findById(Long id);
    VacunaE save(VacunaE vacunaE);
    void delete(Long id);
    
}
