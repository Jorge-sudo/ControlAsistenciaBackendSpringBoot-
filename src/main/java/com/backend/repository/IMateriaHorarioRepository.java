package com.backend.repository;

import com.backend.entities.MateriaHorario;

import java.util.List;

public interface IMateriaHorarioRepository {

    List<MateriaHorario> getMateriaHorarios();

    MateriaHorario getMateriaHorario(long id);

    void guardarMateriaHorario(MateriaHorario materiaHorario);

    void eliminarMateriaHorario(long id);
}
