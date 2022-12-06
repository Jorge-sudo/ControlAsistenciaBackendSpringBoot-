package com.backend.repository;

import com.backend.entities.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    List<Usuario> getUsuarios();
    Usuario getUsuario(long id);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(long id);
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
