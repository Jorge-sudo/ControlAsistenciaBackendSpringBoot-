package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "materia_horario")
public class MateriaHorario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_materia_Horario")
    private long idMateriaHorario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sigla")
    private Materia materia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_horario")
    private Horario horario;

    public MateriaHorario() {
    }

    public MateriaHorario(long idMateriaHorario, Materia materia, Horario horario) {
        this.idMateriaHorario = idMateriaHorario;
        this.materia = materia;
        this.horario = horario;
    }
}
