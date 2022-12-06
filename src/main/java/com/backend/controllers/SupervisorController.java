package com.backend.controllers;

import com.backend.entities.Supervisor;
import com.backend.repository.ISupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupervisorController {
    @Autowired
    private ISupervisorRepository iSupervisorRepository;

    @GetMapping("/api/supervisores")
    public List<Supervisor> listarSupervisores(){
        return iSupervisorRepository.getSupervisores();
    }

    @GetMapping("/api/supervisores/{id}")
    public Supervisor supervisorPorId(@PathVariable String id){
        return iSupervisorRepository.getSupervisor(Long.parseLong(id));
    }

    @DeleteMapping("/api/supervisores/{id}")
    public void eliminarSupervisor(@PathVariable String id){
        iSupervisorRepository.eliminarSupervisor(Long.parseLong(id));
    }

    @PostMapping("/api/supervisores")
    public void guardarSupervisor(@RequestBody Supervisor supervisor){
        iSupervisorRepository.guardarSupervisor(supervisor);
    }
}
