package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "materia_asignado")
public class MateriaAsignado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_materia_Asignado")
    private long idMateriaAsignado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sigla")
    private Materia materia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    public MateriaAsignado() {

    }

    public MateriaAsignado(long idMateriaAsignado, Materia materia, Carrera carrera) {
        this.idMateriaAsignado = idMateriaAsignado;
        this.materia = materia;
        this.carrera = carrera;
    }
}
