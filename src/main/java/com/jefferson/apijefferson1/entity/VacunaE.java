package com.jefferson.apijefferson1.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table( name = "vacunas")
@Getter
@Setter
@ToString
public class VacunaE implements Serializable {
    

   private static final long serialVersionUID = 1L ; 


   @Id
   @Column(name = "id")  
   @GeneratedValue(strategy = GenerationType.AUTO )   
   private Long id;


   @Column(name = "id_empledo_vacu")  
   private Long idEmpleadoVacuna;


   @Column(name ="numero_doci_vacu")
   private int numeroVacuna;

   @Column(name = "fecha_vacu")
   private Date fechaVacuna;

   @Column(name = "tipo_vacu")
   private String tipoVacuna;  
   
    public VacunaE() {
      
   }

  

   

}
