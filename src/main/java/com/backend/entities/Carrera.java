package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Carrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_carrera")
    private long idCarrera;
    private String nombre;
    private String bloque;
    //el name hace referencia a la tabla de carrera y el referencedColumName hace referencia a la tabla Turno

    @JsonIgnore
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno",referencedColumnName = "id_turno")
    private Turno turno;

    public Carrera(){

    }

    public Carrera(long idCarrera, String bloque, String nombre) {
        this.idCarrera = idCarrera;
        this.bloque = bloque;
        this.nombre = nombre;
    }
}
