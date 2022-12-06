package com.backend.repository;

import com.backend.entities.UsuarioRol;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IUsuarioRolRepository {

    List<UsuarioRol> getUsuariosRols();

    UsuarioRol getUsuarioRol(long id);

    void guardarUsuarioRol(UsuarioRol usuarioRol);

    void eliminarUsuarioRol(long id);

}
