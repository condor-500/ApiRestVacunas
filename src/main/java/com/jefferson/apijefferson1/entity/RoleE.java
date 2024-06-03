package com.jefferson.apijefferson1.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "roles")
@Getter
@Setter
public class RoleE implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id ;

    @Column(unique = true , length = 20)
    private String nombre ;

}
