package com.backend.repository;


import com.backend.entities.Carrera;

import java.util.List;

public interface ICarreraRepository {
    List<Carrera> getCarreras();
    Carrera getCarrera(long id);
    void guardarCarrera(Carrera carrera);
    void eliminarCarrera(long id);
}
