package com.backend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_turno")
    private long idTurno;
    private String nombre;

    @OneToMany(mappedBy = "turno")
    private List<Carrera> carreras;

    @OneToMany(mappedBy = "turno")
    private List<Horario> horarios;

    public Turno(){

    }

    public Turno(long idTurno, String nombre) {
        this.idTurno = idTurno;
        this.nombre = nombre;
    }
}
