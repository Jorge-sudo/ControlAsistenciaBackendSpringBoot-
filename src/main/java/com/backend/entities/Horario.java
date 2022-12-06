package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
public class Horario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_horario")
    private long idHorario;
    @Column(name = "hora_inicio")
    private Time horaInicio;
    @Column(name = "hora_final")
    private Time horaFinal;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Horario(){
    }

    public Horario(long idHorario, Time horaInicio, Time horaFinal) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
}
