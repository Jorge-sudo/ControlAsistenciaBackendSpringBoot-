package com.backend.controllers;

import com.backend.entities.Materia;
import com.backend.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MateriaController {
    @Autowired
    IMateriaRepository iMateriaRepository;

    @GetMapping("/api/materias")
    public List<Materia> listarMaterias(){
        return iMateriaRepository.getMaterias();
    }

    @GetMapping("/api/materias/{id}")
    public Materia usuarioPorId(@PathVariable String id){
        return iMateriaRepository.getMateria(Long.parseLong(id));
    }

    @DeleteMapping("/api/materias/{sigla}")
    public void eliminarMateria(@PathVariable String sigla){
        iMateriaRepository.eliminarMateria(sigla);
    }

    @PostMapping("/api/materias")
    public void guardarMateria(@RequestBody Materia materia){
        iMateriaRepository.guardarMateria(materia);
    }
}
