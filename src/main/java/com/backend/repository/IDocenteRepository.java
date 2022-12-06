package com.backend.repository;


import com.backend.entities.Docente;

import java.util.List;

public interface IDocenteRepository {
    List<Docente> getDocentes();
    Docente getDocente(long id);
    void guardarDocente(Docente docente);
    void eliminarDocente(long id);
}
