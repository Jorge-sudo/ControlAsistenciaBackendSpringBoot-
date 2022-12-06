package com.backend.repository;

import com.backend.entities.Horario;

import java.util.List;

public interface IHorarioRepository {

    List<Horario> getHorarios();

    Horario getHorario(long id);

    void guardarHorario(Horario horario);

    void eliminarHorario(long id);

}
