package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Materia {
    @Id
    private String sigla;
    private String nombre;
    private String aula;
    private int piso;
    private int semestre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci")
    private Docente docente;

    public Materia() {
    }

    public Materia(String sigla, String nombre, String aula, int piso, int semestre) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.aula = aula;
        this.piso = piso;
        this.semestre = semestre;
    }
}
