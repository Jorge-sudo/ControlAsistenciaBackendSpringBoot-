package com.backend.controllers;

import com.backend.entities.Usuario;
import com.backend.repository.IUsuarioRepository;
import com.backend.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/api/usuarios")
    public List<Usuario> listarUsuarios(/*@RequestHeader(value = "Authorization")String token*/){
        /*if(!validarToken(token)){
            return null;
        }*/
        return iUsuarioRepository.getUsuarios();
    }

    @GetMapping("/api/usuarios/{id}")
    public Usuario usuarioPorId(@PathVariable String id){
        return iUsuarioRepository.getUsuario(Long.parseLong(id));
    }

    @DeleteMapping("/api/usuarios/{id}")
    public void eliminarUsuario(@PathVariable String id){
        iUsuarioRepository.eliminarUsuario(Long.parseLong(id));
    }

    @PostMapping("/api/usuarios")
    public void guardarUsuario(@RequestBody Usuario usuario){
        // Utilizaremos una libreria para encriptar el password y asi guardarlo a la base de datos
        //A esto se le llama HASH
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        //Convertimos la contraseña a argon
        //hash(cantidadIteraciones,memoria, hilos de proceso, contraseña) mientras mas iteraciones mas seguro pero lento es
        String hash = argon2.hash(1, 1024, 1, usuario.getContrasenia());
        usuario.setContrasenia(hash);
        iUsuarioRepository.guardarUsuario(usuario);
    }

    private boolean validarToken (String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
