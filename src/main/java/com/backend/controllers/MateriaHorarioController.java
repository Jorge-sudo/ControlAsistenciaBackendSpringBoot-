package com.backend.controllers;

import com.backend.entities.MateriaAsignado;
import com.backend.entities.MateriaHorario;
import com.backend.repository.IMateriaHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MateriaHorarioController {

    @Autowired
    IMateriaHorarioRepository iMateriaHorarioRepository;


    @GetMapping("/api/materiaHorario")
    public List<MateriaHorario> listarMateriaHorarios(){
        return iMateriaHorarioRepository.getMateriaHorarios();
    }

    @GetMapping("/api/materiaHorario/{id}")
    public MateriaHorario materiaHorarioPorId(@PathVariable String id){
        return iMateriaHorarioRepository.getMateriaHorario(Long.parseLong(id));
    }

    @DeleteMapping("/api/materiaHorario/{id}")
    public void eliminarMateriaHorario(@PathVariable String id){
        iMateriaHorarioRepository.eliminarMateriaHorario(Long.parseLong(id));
    }

    @PostMapping("/api/materiaHorario")
    public void guardarMateriaHorario(@RequestBody MateriaHorario materiaHorario){
        iMateriaHorarioRepository.guardarMateriaHorario(materiaHorario);
    }

}
