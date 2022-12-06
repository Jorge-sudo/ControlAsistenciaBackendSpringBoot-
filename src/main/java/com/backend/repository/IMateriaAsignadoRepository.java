package com.backend.repository;

import com.backend.entities.MateriaAsignado;

import java.util.List;

public interface IMateriaAsignadoRepository {
    List<MateriaAsignado> getMateriasAsignados();
    MateriaAsignado getMateriaAsignado(long id);
    void guardarMateriaAsignado(MateriaAsignado materiaAsignado);
    void eliminarMateriaAsignado(long id);
}
