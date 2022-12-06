package com.backend.repository;

import com.backend.entities.Turno;

import java.util.List;

public interface ITurnoRepository {
    List<Turno> getTurnos();
    Turno getTurno(long id);
    void guardarTurno(Turno turno);
    void eliminarTurno(long id);
}
