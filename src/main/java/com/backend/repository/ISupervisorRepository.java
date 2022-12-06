package com.backend.repository;

import com.backend.entities.Supervisor;

import java.util.List;

public interface ISupervisorRepository {
    List<Supervisor> getSupervisores();
    Supervisor getSupervisor(long id);
    void guardarSupervisor(Supervisor supervisor);
    void eliminarSupervisor(long id);
}
