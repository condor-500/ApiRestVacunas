package com.jefferson.apijefferson1.implService;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jefferson.apijefferson1.dto.IVacunaDTO;
import com.jefferson.apijefferson1.entity.VacunaE;
import com.jefferson.apijefferson1.services.IVacunaService;

@Service
public class VacunaImplS implements IVacunaService {


    @Autowired
    IVacunaDTO vacunaDTO;


    @Override
    public List<VacunaE> listVacuna() {
        // TODO Auto-generated method stub
        return (List<VacunaE>) vacunaDTO.findAll();
    }


    @Override
    public VacunaE findById(Long id) {
      Optional<VacunaE> vacunaE = vacunaDTO.findById(id);
        // TODO Auto-generated method stub
       return  vacunaE.get();  

    }


    @Override
    @Transactional
    public VacunaE save(VacunaE vacunaE) {
      
     return vacunaDTO.save(vacunaE);
    }


    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
