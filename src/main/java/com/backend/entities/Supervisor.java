package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@PrimaryKeyJoinColumn(name="ci")
public class Supervisor extends Persona{

    private long ci;
    private String turno;


    public Supervisor(){

    }

    public Supervisor(long ci, String turno) {
        this.ci = ci;
        this.turno = turno;
    }

    public Supervisor(int ci, String nombre, String apellido, String profesion, String genero, long ci1, String turno) {
        super(ci, nombre, apellido, profesion, genero);
        this.ci = ci1;
        this.turno = turno;
    }
}
