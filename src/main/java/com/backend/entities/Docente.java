package com.backend.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@PrimaryKeyJoinColumn(name="ci")
@Table(name = "docente")
public class Docente extends Persona{
    private long ci;
    @Column(name = "cod_rfid")
    private String codRfid;

    public Docente() {
    }

    public Docente(long ci, String codRfid) {
        this.ci = ci;
        this.codRfid = codRfid;
    }

    public Docente(int ci, String nombre, String apellido, String profesion, String genero, long ci1, String codRfid) {
        super(ci, nombre, apellido, profesion, genero);
        this.ci = ci1;
        this.codRfid = codRfid;
    }

}
