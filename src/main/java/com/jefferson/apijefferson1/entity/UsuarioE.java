package com.jefferson.apijefferson1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioE implements Serializable {
    
    private static final long serialVersionUID = 1L ; 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true , name = "nombre_usua", length = 50 )
    private String nombre;

    @Column(name = "contrasenia_usua",length = 70 )
    private String contrasenia;

    
    @Column(name = "estado_usua")
    private Boolean estado;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name ="usuario_autoridad", joinColumns = @JoinColumn(name = "UsuarioE_id"),
     inverseJoinColumns = @JoinColumn(name = "RoleE_id"),
     uniqueConstraints = {@UniqueConstraint(columnNames = {"UsuarioE_id","RoleE_id"}) } )
    private List<RoleE> roles ;

        
    
}
