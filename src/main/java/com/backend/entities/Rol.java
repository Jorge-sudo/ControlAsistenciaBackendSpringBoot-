package com.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "rol")
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_rol")
    private long idRol;
    private String nombre;


    public Rol() {
    }

    public Rol(long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }
}
