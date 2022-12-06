package com.backend.repository;


import com.backend.entities.Materia;

import java.util.List;

public interface IMateriaRepository {
    List<Materia> getMaterias();
    Materia getMateria(long id);
    void guardarMateria(Materia materia);
    void eliminarMateria(String sigla);
}
