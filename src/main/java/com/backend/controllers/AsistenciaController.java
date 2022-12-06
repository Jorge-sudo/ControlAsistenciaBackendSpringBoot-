package com.backend.controllers;

import com.backend.entities.Asistencia;
import com.backend.entities.Docente;
import com.backend.repository.IAsistenciaRepository;
import com.backend.repository.ICarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AsistenciaController {

    @Autowired
    IAsistenciaRepository iAsistenciaRepository;

    @GetMapping("/api/asistencias")
    public List<Asistencia> listarAsistencias(){
        return iAsistenciaRepository.getAsistencias();
    }

    @GetMapping("/api/asistencias/{id}")
    public Asistencia asistenciaPorId(@PathVariable String id){
        return iAsistenciaRepository.getAsistencia(Long.parseLong(id));
    }

    @DeleteMapping("/api/asistencias/{id}")
    public void eliminarAsistencia(@PathVariable String id){
        iAsistenciaRepository.eliminarAsistencia(Long.parseLong(id));
    }

    @PostMapping("/api/asistencias")
    public void guardarAsistencia(@RequestBody Asistencia asistencia){
        iAsistenciaRepository.guardarAsistencia(asistencia);
    }

    @GetMapping("/api/asistencias/registar/{ci}")
    public void registrarAsistencia(@PathVariable String ci){
        iAsistenciaRepository.registrarAsistencia(Long.parseLong(ci));
    }
}
