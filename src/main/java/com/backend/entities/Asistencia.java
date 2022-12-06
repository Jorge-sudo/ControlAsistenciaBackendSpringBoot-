package com.backend.entities;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
public class Asistencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idAsistencia;
    private Date fecha;
    @Column(name = "hora_entrada")
    private Time horaEntrada;
    @Nullable
    @Column(name = "hora_salida")
    private Time horaSalida;
    @Column(name = "cant_estudiantes")
    private int cantidadEstudiantes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci")
    private Docente docente;

    public Asistencia(){

    }

    public Asistencia(Date fecha, Time horaEntrada, int cantidadEstudiantes, Usuario usuario, Docente docente) {
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.usuario = usuario;
        this.docente = docente;
    }
}
