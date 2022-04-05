package com.jefferson.apijefferson1.dto;


import java.util.Date;
import java.util.List;

import com.jefferson.apijefferson1.entity.EmpleadoE;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface IEmpleadoDTO  extends CrudRepository<EmpleadoE,Long> {


      List<EmpleadoE> findByEstadoVacunacion(String estadoVacunacion);
     
     @Query(value= "select * from empleados e left join vacunas v on e.id = v.id_empledo_vacu where v.tipo_vacu  = :tipoVacuna" , nativeQuery = true)
     List<EmpleadoE> findByTipoVacuna(@Param("tipoVacuna") String tipoVacuna);

     @Query( value = "select * from empleados e left join vacunas v on e.id = v.id_empledo_vacu where v.fecha_vacu between ?1 and ?2", nativeQuery = true)
      List<EmpleadoE>  findbyFechaVacuDesdeHasta(Date desdef, Date hastaf );
     
}
