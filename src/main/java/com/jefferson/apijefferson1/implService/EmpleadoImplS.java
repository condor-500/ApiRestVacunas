package com.jefferson.apijefferson1.implService;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.jefferson.apijefferson1.dto.IEmpleadoDTO;
import com.jefferson.apijefferson1.entity.EmpleadoE;
import com.jefferson.apijefferson1.entity.VacunaE;
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
        EmpleadoE empleadoA = findById(null);
        empleadoA.setCedula(empleado.getCedula());
        empleadoA.setNombre(empleado.getNombre());
        empleadoA.setApellido(empleado.getApellido());
        empleadoA.setMail(empleado.getMail());
        empleadoA.setDireccion(empleado.getDireccion());
        empleadoA.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoA.setEstadoVacunacion(empleado.getEstadoVacunacion());
        empleadoA.setTelefono(empleado.getTelefono());
        VacunaE vacuna = new VacunaE();
        vacuna.setIdEmpleadoVacuna(empleado.getId());
        vacuna.setNumeroVacuna(empleado.getVacunas().get(0).getNumeroVacuna());
        vacuna.setFechaVacuna(empleado.getVacunas().get(0).getFechaVacuna());
        vacuna.setTipoVacuna(empleado.getVacunas().get(0).getTipoVacuna());
        empleadoA.addVacuna(vacuna);
        empleadoDTO.save(empleadoA);
        return empleadoA;
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
