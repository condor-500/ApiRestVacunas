package com.jefferson.apijefferson1.dto;

import java.util.List;

import com.jefferson.apijefferson1.entity.VacunaE;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IVacunaDTO extends CrudRepository<VacunaE, Long> {

    @Query(value = "SELECT v from VacunaE v")
    List<VacunaE> listVacuna();
    
}
