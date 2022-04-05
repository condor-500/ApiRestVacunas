package com.jefferson.apijefferson1.services;

import java.util.Date;
import java.util.List;

import com.jefferson.apijefferson1.entity.EmpleadoE;

public interface IEmpleadoS {
 
    List<EmpleadoE> findAll();
	
    EmpleadoE findById(Long id);
	
	EmpleadoE save(EmpleadoE empleado);
	
	void delete(Long id);    

    List<EmpleadoE> findByEstadoVacunacion(String estadoVacunacion);

    public List<EmpleadoE> findByTipoVacuna(String tipoVacuna);

    List<EmpleadoE> findByFechaVacunacion(Date desdef , Date hastaf );

}
