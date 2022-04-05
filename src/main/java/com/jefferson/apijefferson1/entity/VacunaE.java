package com.jefferson.apijefferson1.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;


@Entity
@Table( name = "vacunas")
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

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getNumeroVacuna() {
      return numeroVacuna;
   }

   public void setNumeroVacuna(int numeroVacuna) {
      this.numeroVacuna = numeroVacuna;
   }

   public Date getFechaVacuna() {
      return fechaVacuna;
   }


   public void setFechaVacuna(Date fechaVacuna) {
      this.fechaVacuna = fechaVacuna;
   }


   public String getTipoVacuna() {
      return tipoVacuna;
   }


   public void setTipoVacuna(String tipoVacuna) {
      this.tipoVacuna = tipoVacuna;
   }



   public Long getIdEmpleadoVacuna() {
      return idEmpleadoVacuna;
   }



   public void setIdEmpleadoVacuna(Long idEmpleadoVacuna) {
      this.idEmpleadoVacuna = idEmpleadoVacuna;
   }



   @Override
   public String toString() {
      return "VacunaE [fechaVacuna=" + fechaVacuna + ", id=" + id + ", idEmpleadoVacuna=" + idEmpleadoVacuna
            + ", numeroVacuna=" + numeroVacuna + ", tipoVacuna=" + tipoVacuna + "]";
   }


  


 





   

}
