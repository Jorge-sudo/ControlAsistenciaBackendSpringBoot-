package com.backend.controllers;

import com.backend.entities.Carrera;
import com.backend.repository.ICarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarreraController {

    @Autowired
    ICarreraRepository iCarreraRepository;

    @GetMapping("/api/carreras")
    public List<Carrera> listarUsuarios(){
        return iCarreraRepository.getCarreras();
    }

    @GetMapping("/api/carreras/{id}")
    public Carrera usuarioPorId(@PathVariable String id){
        return iCarreraRepository.getCarrera(Long.parseLong(id));
    }

    @DeleteMapping("/api/carreras/{id}")
    public void eliminarUsuario(@PathVariable String id){
        iCarreraRepository.eliminarCarrera(Long.parseLong(id));
    }

    @PostMapping("/api/carreras")
    public void guardarUsuario(@RequestBody Carrera carrera){
        iCarreraRepository.guardarCarrera(carrera);
    }
}
