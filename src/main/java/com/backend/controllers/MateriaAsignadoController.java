package com.backend.controllers;

import com.backend.entities.MateriaAsignado;
import com.backend.repository.IMateriaAsignadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MateriaAsignadoController {
    @Autowired
    IMateriaAsignadoRepository iMateriaAsignadoRepository;

    @GetMapping("/api/materiasAsignados")
    public List<MateriaAsignado> listarMateriasAsignados(){
        return iMateriaAsignadoRepository.getMateriasAsignados();
    }

    @GetMapping("/api/materiasAsignados/{id}")
    public MateriaAsignado materiaAsignadoPorId(@PathVariable String id){
        return iMateriaAsignadoRepository.getMateriaAsignado(Long.parseLong(id));
    }

    @DeleteMapping("/api/materiasAsignados/{id}")
    public void eliminarMateriaAsignado(@PathVariable String id){
        iMateriaAsignadoRepository.eliminarMateriaAsignado(Long.parseLong(id));
    }

    @PostMapping("/api/materiasAsignados")
    public void guardarMateriaAsignado(@RequestBody MateriaAsignado materiaAsignado){
        iMateriaAsignadoRepository.guardarMateriaAsignado(materiaAsignado);
    }
}
