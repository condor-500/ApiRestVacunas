package com.jefferson.apijefferson1.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table( name = "roles")

public class RoleE implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id ;

    @Column(unique = true , length = 20)
    private String nombre ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    



}
