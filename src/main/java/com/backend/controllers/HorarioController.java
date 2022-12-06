package com.backend.controllers;

import com.backend.entities.Horario;
import com.backend.repository.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    IHorarioRepository iHorarioRepository;

    @GetMapping("/api/horarios")
    public List<Horario> listarMaterias(){
        return iHorarioRepository.getHorarios();
    }

    @GetMapping("/api/horarios/{id}")
    public Horario usuarioPorId(@PathVariable String id){
        return iHorarioRepository.getHorario(Long.parseLong(id));
    }

    @DeleteMapping("/api/horarios/{id}")
    public void eliminarHorario(@PathVariable String id){
        iHorarioRepository.eliminarHorario(Long.parseLong(id));
    }

    @PostMapping("/api/horarios")
    public void guardarHorario(@RequestBody Horario horario){
        iHorarioRepository.guardarHorario(horario);
    }

}
