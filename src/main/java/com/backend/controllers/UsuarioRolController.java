package com.backend.controllers;

import com.backend.entities.UsuarioRol;
import com.backend.repository.IUsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRolController {

    @Autowired
    private IUsuarioRolRepository iUsuarioRolRepository;

    @GetMapping("/api/usuariosRols")
    public List<UsuarioRol> listarUsuariosRol(){
        return iUsuarioRolRepository.getUsuariosRols();
    }

    @GetMapping("/api/usuariosRols/{id}")
    public UsuarioRol getById(@PathVariable String id){
        return iUsuarioRolRepository.getUsuarioRol(Long.parseLong(id));
    }

    @DeleteMapping("/api/usuariosRols/{id}")
    public void remove(@PathVariable String id){
        iUsuarioRolRepository.eliminarUsuarioRol(Long.parseLong(id));
    }

    @PostMapping("/api/usuariosRols")
    public void save(@RequestBody UsuarioRol usuarioRol){
        iUsuarioRolRepository.guardarUsuarioRol(usuarioRol);
    }
}
