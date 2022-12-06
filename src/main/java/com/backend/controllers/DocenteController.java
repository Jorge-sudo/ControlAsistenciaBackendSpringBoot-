package com.backend.controllers;


import com.backend.entities.Docente;
import com.backend.repository.IDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocenteController {
    @Autowired
    private IDocenteRepository iDocenteRepository;

    @GetMapping("/api/docentes")
    public List<Docente> listarDocentes(){
        return iDocenteRepository.getDocentes();
    }

    @GetMapping("/api/docentes/{id}")
    public Docente docentePorId(@PathVariable String id){
        return iDocenteRepository.getDocente(Integer.parseInt(id));
    }

    @DeleteMapping("/api/docentes/{id}")
    public void eliminarDocente(@PathVariable String id){
        iDocenteRepository.eliminarDocente(Long.parseLong(id));
    }

    @PostMapping("/api/docentes")
    public void guardarDocente(@RequestBody Docente docente){
        iDocenteRepository.guardarDocente(docente);
    }
}
