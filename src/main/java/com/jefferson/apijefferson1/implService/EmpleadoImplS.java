package com.jefferson.apijefferson1.implService;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.jefferson.apijefferson1.dto.IEmpleadoDTO;
import com.jefferson.apijefferson1.entity.EmpleadoE;
import com.jefferson.apijefferson1.services.IEmpleadoS;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpleadoImplS implements IEmpleadoS  {

    @Autowired
    private IEmpleadoDTO  empleadoDTO;


    @Override
    public List<EmpleadoE> findAll() {
        
        return (List<EmpleadoE>) empleadoDTO.findAll();
    }

    @Override
    public EmpleadoE findById(Long id) {
        
        return empleadoDTO.findById(id).orElse(null);
    }

    @Override
    public EmpleadoE save(EmpleadoE empleado) {
     
        return empleadoDTO.save(empleado);
    }

    @Override
    public void delete(Long id) {
        empleadoDTO.deleteById(id);
        
    }

  

    @Override
    public List<EmpleadoE> findByEstadoVacunacion(String estadoVacunacion) {
       
        return empleadoDTO.findByEstadoVacunacion(estadoVacunacion);
    }

    @Override
  
    public List<EmpleadoE> findByTipoVacuna(String tipoVacuna) {
 
        return empleadoDTO.findByTipoVacuna(tipoVacuna);
    }

    @Override
    public List<EmpleadoE> findByFechaVacunacion(Date desdef, Date hastaf) {
      
        return empleadoDTO.findbyFechaVacuDesdeHasta(desdef, hastaf) ;
    }



    



    
}
