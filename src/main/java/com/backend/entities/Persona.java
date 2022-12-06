package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "persona")
@Data
public class Persona {
    @Id
    @Column(name = "ci")
    private long ci ;
    private String nombre;
    private String apellido;
    private String profesion;
    private String genero;

    public Persona(){

    }

    public Persona(long ci, String nombre, String apellido, String profesion, String genero) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.genero = genero;
    }
}
