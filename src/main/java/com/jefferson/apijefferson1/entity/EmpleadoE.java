package com.jefferson.apijefferson1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.jefferson.apijefferson1.common.ValidaCedula;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;




@Entity
@Table( name = "empleados")
public class EmpleadoE  implements Serializable  {


    private static final long serialVersionUID = 1L ; 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id ;
    
    @Column(name = "cedula_empl", length = 10, unique= true )
    @NotEmpty(message = "No puede estar vacio")
    @Size(min=10, max=10, message = "Tiene que tener 10 caracteres")
    @Pattern(regexp = "[0-9]*",message = "Solo Puede contener numeros")
    @ValidaCedula(message = "cedula Invalida" )
    private String cedula;
    
    @Column(name = "nombre_empl",length = 200)
    @NotEmpty(message = "No puede estar vacio")
    @Pattern(regexp = "[A-Z a-z ]{2,254}",message = "Solo Puede contener caracteres")
    private String nombre;
    
    @Column(name = "apellido_empl",length = 200)
    @NotEmpty(message = "No puede estar vacio")
    @Pattern(regexp = "[A-Z a-z ]{2,254}",message = "Solo Puede contener caracteres")
    private String apellido;
    
    @Column(name= "email_empl")
    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No tiene formato de email")
    private String mail;

    @Column(name = "fechan_empl")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date fechaNacimiento;
    
    @Column(name = "direccion_empl")
    private String direccion;

    @Column(name = "telefono_empl")
    private String telefono;

    @Column(name ="estadovacu_empl")
    private String estadoVacunacion;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
                orphanRemoval = true ) 
    @JoinColumn(name ="id_empledo_vacu",referencedColumnName = "id" )            
    private  List<VacunaE> vacunas  = new ArrayList<>();

    public EmpleadoE() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(String estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public List<VacunaE> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<VacunaE> vacunas) {
        this.vacunas = vacunas;
    }

    public void addVacuna(VacunaE vacuna ){
       
        vacunas.add(vacuna);
       
        
    }

    public void removeRacuna(VacunaE vacuna){
        vacunas.remove(vacuna);
    }

    
}
