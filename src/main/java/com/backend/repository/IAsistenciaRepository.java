package com.backend.repository;


import com.backend.entities.Asistencia;

import java.util.List;

public interface IAsistenciaRepository {
    List<Asistencia> getAsistencias();
    Asistencia getAsistencia(long id);
    void guardarAsistencia(Asistencia asistencia);
    void eliminarAsistencia(long id);

    void registrarAsistencia(long ci);
}
