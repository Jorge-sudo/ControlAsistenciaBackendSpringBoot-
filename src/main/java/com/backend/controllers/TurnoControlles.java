package com.backend.controllers;

import com.backend.entities.Turno;
import com.backend.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TurnoControlles {

    @Autowired
    ITurnoRepository iTurnoRepository;

    @GetMapping("/api/turnos")
    public List<Turno> listarTurnos(){
        return iTurnoRepository.getTurnos();
    }

    @GetMapping("/api/turnos/{id}")
    public Turno turnoPorNombre(@PathVariable String id){
        return iTurnoRepository.getTurno(Long.parseLong(id));
    }
}
